package com.moonrakerAnalytics.app

import org.scalatra._
import scalate.ScalateSupport

class MyMoonrakerAnalyticsServlet extends MoonrakerAnalyticsStack {

  get("/") {
    contentType="text/html"
    ssp("/index")
  }

  post("/sources") {
    contentType="json"
    // status = SourcesController.create(params).status
    val body = SourcesController.create(params).body
    Ok(s"$body")
  }

  post("/sources/:application/data") {
    contentType="json"
    // status = DataController.create(params).status
    val requestData = Map("payload" -> request.body, "application" -> params("application"))
    val responseBody = DataController.create(requestData).body

    Ok(s"$responseBody")
  }

  notFound {
    contentType="text/html"
    ssp("/error")
  }

}
