package com.moonrakerAnalytics.app

object DataController extends MoonrakerAnalyticsStack {

  def create(params: Map[String, String]): Response = {
    val request = new Request( params("payload"), params("application") )
    val application = params("application")

    if (request.isValid) {
      Request.save(request)
      val response = new Response( Map("status" -> 200, "body" -> s"Data stored for $application"))
      return response
    } else if (!Source.registered(application)) {
      val response = new Response( Map("status" -> 403, "body" -> "Application is not registered"))
      return response
    } else if (Request.duplicateData(request)) {
      val response = new Response( Map("status" -> 403, "body" -> "Duplicate request"))
      return response
    } else {
      val response = new Response( Map("status" -> 400, "body" -> "Missing parameter"))
      return response
    }
  }

}