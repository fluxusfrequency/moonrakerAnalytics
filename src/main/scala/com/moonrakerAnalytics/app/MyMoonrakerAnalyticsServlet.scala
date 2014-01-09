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
   Ok("Ok, created an identifier for you.")
  }

  post("/sources/:application/data") {
    contentType="json"
    Ok("Ok, saved your data.")
  }

  notFound {
    contentType="text/html"
    ssp("/error")
  }

}
