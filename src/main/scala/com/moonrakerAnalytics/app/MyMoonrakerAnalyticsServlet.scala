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
    // body = SourcesController.create(params).body
    Ok("Ok, created an identifier for you.")
  }

  post("/sources/:application/data") {
    contentType="json"
    // status = DataController.create(params).status
    // body = DataController.create(params).body
    Ok("Ok, saved your data.")
  }

  notFound {
    contentType="text/html"
    ssp("/error")
  }

}
