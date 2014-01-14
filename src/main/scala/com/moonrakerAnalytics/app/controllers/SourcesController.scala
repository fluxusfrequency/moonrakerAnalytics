package com.moonrakerAnalytics.app

object SourcesController extends MoonrakerAnalyticsStack {

  def create(params: Map[String, String]): Response = {
    val source = new Source( params("identifier"), params("rootUrl"))
    if(source.isValid) {
      source.save
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

  //   if (source.isValid) {
  //     source.save
  //     val status = 200
  //     val body = "Created $params(\"identifier\") source for url $params(\"rootUrl\")}"
  //   } else {
  //     val status = statusFor(source.errors.first.category)
  //     // val body = source.errors.collect{|e| e.message}.join(", ")
  //   }

  // private def statusFor(flag: String): Match = {
  //   case "missingParameter" => 400
  //   case "repeatedIdentifier" => 403
  //   case _ => "No return status defined for flag $flag"
  // }


}