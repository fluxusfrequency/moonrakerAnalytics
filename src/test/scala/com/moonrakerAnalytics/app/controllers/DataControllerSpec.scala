package com.moonrakerAnalytics.app

import org.scalatest._

class DataControllerSpec extends FlatSpec with Matchers {
  val params = Map("payload" -> "hello", "application" -> "JetFuelExpress")

  it should "return a 200 when the application is registered" in {
    Source.count shouldBe 0
    Source.create(Map("identifier" -> "JetFuelExpress", "rootUrl" -> "jfx.herokuapp.com")) shouldBe true
    Source.count shouldBe 1
    Source.all(0).identifier shouldBe "JetFuelExpress"
    Source.all(0) shouldBe a [Source]
    Source.registered(params("application")) shouldBe true
    val response = DataController.create(params)
    response.status shouldBe 200
    response.body shouldBe "Data stored for JetFuelExpress"
    Request.destroyAll
    Source.destroyAll
  }

  it should "return 403 and a message if application is not registered" in {
    pending
    val result = DataController.create(params)
    result.status shouldBe 403
    result.body shouldBe "Application is not registered"
    Request.destroyAll
    Source.destroyAll
  }

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

