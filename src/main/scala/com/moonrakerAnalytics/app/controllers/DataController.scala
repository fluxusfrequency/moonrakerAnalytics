package com.moonrakerAnalytics.app

object DataController extends MoonrakerAnalyticsStack {
  def create(params: Map[String, String]): Response = {
    val request = new Request( params("payload"), params("application"))
    val application = params("application")
    if (request.isValid) {
      request.save
      val response = new Response( Map("status" -> 200, "body" -> s"Data stored for $application"))
      return response
    } else {
      val response = new Response( Map("status" -> 403, "body" -> "Application is not registered"))
      return response
    }
  }
  // private def status_for(flag: String) match {
  //   case ("missingParameter") => 400
  //   case ("repeatedIdentifier") => 403
  //   case (_) => "No return status defined for this flag."
  // }


}