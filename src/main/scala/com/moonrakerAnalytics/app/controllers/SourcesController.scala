package com.moonrakerAnalytics.app

object SourcesController extends MoonrakerAnalyticsStack {

  def create(params: Map[String, String]): Response = {
    val source = new Source( params("identifier"), params("rootUrl"))

    if(source.isValid) {
      Source.save(source)
      val response = new Response(Map("status" -> 200, "body" -> s"Created source ${source.identifier} for url ${source.rootUrl}."))
      return response
    } else if (source.errors("category") == "already registered"){
      val message = source.errors("message")
      val response = new Response(Map("status" -> 403, "body" -> s"$message"))
      return response
    } else {
      val message = source.errors("message")
      val response = new Response(Map("status" -> 400, "body" -> s"$message"))
      return response
    }
  }

}