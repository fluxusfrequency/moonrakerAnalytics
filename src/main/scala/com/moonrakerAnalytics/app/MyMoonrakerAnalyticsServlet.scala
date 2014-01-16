package com.moonrakerAnalytics.app

import org.scalatra._
import scalate.ScalateSupport

class MyMoonrakerAnalyticsServlet extends MoonrakerAnalyticsStack {

  // JSON
  post("/sources") {
    contentType="json"
    val response = SourcesController.create(params)
    val reponseStatus = response.status
    val responseBody = response.body
    Ok(s"$responseBody")
  }

  // JSON
  post("/sources/:application/data") {
    contentType="json"
    val requestData = Map("payload" -> request.body, "application" -> params("application"))
    val response = DataController.create(requestData)
    val responseBody = response.body
    val responseStatus = response.status

    Ok(s"$responseBody")
    Ok(s"$responseBody")
  }


  get("/") {
    contentType="text/html"
    ssp("/index")
  }

  get("/sources/:application") {
    contentType="text/html"
    ssp("/source")
  }

  get("/sources/:application/urls/*") {
    contentType="text/html"
    ssp("/url")
  }



  notFound {
    // remove content type in case it was set through an action
    contentType = "text/html"
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse ssp("/error")
  }

}
