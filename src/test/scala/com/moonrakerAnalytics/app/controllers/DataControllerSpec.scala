package com.moonrakerAnalytics.app

import org.scalatest._

class DataControllerSpec extends FlatSpec with Matchers {

  def params = Map("payload" -> "hello", "application" -> "JetFuelExpress")

  it should "return 403 and a message if application is not registered" in {
    val response2 = DataController.create(params)
    response2.status shouldBe 403
    response2.body shouldBe "Application is not registered"
  }

  it should "return a 200 when the application is registered" in {
    Source.destroyAll
    Request.destroyAll
    Source.count shouldBe 0
    Source.create(Map("identifier" -> "JetFuelExpress", "rootUrl" -> "jfx.herokuapp.com")) shouldBe true
    Source.all(0).identifier shouldBe "JetFuelExpress"
    Source.all(0) shouldBe a [Source]

    Source.registered("JetFuelExpress") shouldBe true
    val response3 = DataController.create(params)
    response3.status shouldBe 200
    response3.body shouldBe "Data stored for JetFuelExpress"
    Source.destroyAll
    Request.destroyAll
  }

  it should "create a request record" in {
    Source.destroyAll
    Request.destroyAll
    Request.count shouldBe 0
    Source.create(Map("identifier" -> "cruel world", "rootUrl" -> "ack.com"))
    val response4 = DataController.create(Map("payload" -> "goodbye", "application" -> "cruel world"))
    response4.status shouldBe 200
    Request.count shouldBe 1
    Source.destroyAll
    Request.destroyAll
  }

  it should "return 400 when payload is missing" in {
    Source.create(Map("identifier" -> "Mama's Cakes", "rootUrl" -> "mamascakes.org"))
    val response5 = DataController.create(Map("payload" -> null, "application" -> "Mama's Cakes"))
    response5.status shouldBe 400
    response5.body shouldBe "Missing parameter"
  }

  it should "return 403 and a message for duplicate payload" in {
    Source.create(Map("identifier" -> "Billy's BBQ", "rootUrl" -> "billysbbq.com"))
    val valid = DataController.create(Map("payload" -> "Ribs", "application" -> "Billy's BBQ"))
    val invalid = DataController.create(Map("payload" -> "Ribs", "application" -> "Billy's BBQ"))
    invalid.status shouldBe 403
    invalid.body shouldBe "Duplicate request"
  }

}

