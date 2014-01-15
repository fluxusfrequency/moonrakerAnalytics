package com.moonrakerAnalytics.app

import org.scalatest._
import org.scalatest.BeforeAndAfterEach

class DataControllerSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  override def beforeEach() {
    Source.destroyAll
    Request.destroyAll
  }

  def params = Map("payload" -> "hello", "application" -> "JetFuelExpress")

  it should "return 403 and a message if application is not registered" in {
    val response2 = DataController.create(params)
    response2.status shouldBe 403
    response2.body shouldBe "Application is not registered"
  }

  it should "return a 200 when the application is registered" in {
    pending
    Source.count shouldBe 0
    Source.create(Map("identifier" -> "JetFuelExpress", "rootUrl" -> "jfx.herokuapp.com")) shouldBe true
    Source.count shouldBe 1
    Source.all(0).identifier shouldBe "JetFuelExpress"
    Source.all(0) shouldBe a [Source]
    Source.registered(params("application")) shouldBe true
    val response = DataController.create(params)
    response.status shouldBe 200
    response.body shouldBe "Data stored for JetFuelExpress"
  }

  it should "create a request record" in {
    pending
    Request.count shouldBe 0
    DataController.create(params)
    Request.count shouldBe 1
  }

  it should "return 400 when payload is missing" in {
    pending
    val response3 = DataController.create(Map("payload" -> null, "application" -> "Mama's Cakes"))
    response3.status shouldBe 400
    response3.body shouldBe "Missing parameter"
  }

  it should "return 403 and a message for duplicate payload" in {
    pending
    val valid = DataController.create(params)
    val invalid = DataController.create(params)
    invalid.status shouldBe 403
    invalid.body shouldBe "duplicate"
  }

}

