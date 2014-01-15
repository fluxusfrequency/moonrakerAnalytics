package com.moonrakerAnalytics.app

object DataController extends MoonrakerAnalyticsStack {

  def create(params: Map[String, String]): Response = {
    val request = new Request( params("payload"), params("application") )
    val application = params("application")

    if (request.isValid) {
      request.save
      val response = new Response( Map("status" -> 200, "body" -> s"Data stored for $application"))
      return response
    } else if (!Source.registered(application)) {
      val response = new Response( Map("status" -> 403, "body" -> "Application is not registered"))
      return response
    } else {
      val response = new Response( Map("status" -> 400, "body" -> "Missing parameter"))
      return response
    }

  }

  private def statusFor(flag: String): Int = flag match {
    case "missing parameter" => 400
    case "unregistered application" => 403
    case "duplicate request" => 403
    case _ => 404
  }
}