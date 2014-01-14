package com.moonrakerAnalytics.app

object DataController extends MoonrakerAnalyticsStack {
  def create(params: Map[String, String]): Response = {
    val request = new Request( params("payload"), params("application") )
    val application = params("application")
    if (request.isValid) {
      request.save
      val response = new Response( Map("status" -> 200, "body" -> s"Data stored for $application"))
      return response
    } else {
      val response = new Response( Map("status" -> 403, "body" -> "Missing parameter"))
      return response
    }
  }
}