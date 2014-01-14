package com.moonrakerAnalytics.app

import org.scalatest._

class DataControllerSpec extends FlatSpec with Matchers {
  val params = Map("payload" -> "\"{\"url\":\"http://jumpstartlab.com/blog\",\"requestedAt\":\"2013-02-16 21:38:28 -0700\",\"respondedIn\":37,\"referredBy\":\"http://jumpstartlab.com\",\"requestType\":\"GET\",\"parameters\":[],\"eventName\": \"socialLogin\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17\",\"resolutionWidth\":\"1920\",\"resolutionHeight\":\"1280\",\"ip\":\"63.29.38.211\" }\"", "application" -> "JetFuelExpress")
  val application = Source.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))


  it should "accept parameters" in {
    // result = DataController.create()
  //   Source.count shouldBe 0
  //   SourcesController.create(Map("identifier" -> "hello", "rootUrl" -> "world"))
  //   Source.count shouldBe 1
    Source.destroyAll
  }

  // xit should "return 403 and a message" in {
  //   val result = DataController.create(params)
  //   result.status should be 403
  //   result.body should include "not registered"
  // }

  // xit should "create a request record" in {
  //   Request.count should be 0
  //   DataController.create(params)
  //   Request.count should be 1
  // }

  // xit should "return 400 when payload is missing" in {
  //   val result = DataController.create("payload" => null, "application" => application)
  //   result.status should be 400
  //   result.body should include "payload missing"
  // }

  // xit should "return 403 and a message for duplicate payload" {
  //   val valid = DataController.create(params)
  //   val invalid = DataController.create(params)
  //   invalid.status should be 403
  //   invalid.body should include "duplicate"
  // }

}

