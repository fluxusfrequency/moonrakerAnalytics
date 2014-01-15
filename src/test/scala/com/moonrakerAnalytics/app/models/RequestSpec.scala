package com.moonrakerAnalytics.app

import org.scalatest._
import org.scalatest.BeforeAndAfterEach

class RequestSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  override def beforeEach() {
    Request.destroyAll
  }

  def request = new Request("/jk10d2", "JetFuelExpress")

  it should "be a request" in {
    request shouldBe a [Request]
  }

  it should "have data" in {
    request.data shouldBe "/jk10d2"
  }

  it should "have a source" in {
    request.source shouldBe "JetFuelExpress"
  }

  it should "have an exists method" in {
    Request.exists(request) shouldBe false
  }

  it should "not exist when created as a duplicate" in {
    var request4 = new Request(request.data, "griffinApp")
    var request5 = new Request(request.data, "elfApp")
    Request.count shouldBe 0
    request4.save
    Request.exists(request5) shouldBe false
    Request.count shouldBe 1

  }

  it should "have a save method" in {
    var request2 = new Request("/myuri", "orcApp")
    Request.count shouldBe 0
    Request.exists(request2) shouldBe false
    request2.save shouldBe true
    Request.count shouldBe 1
    Request.exists(request2) shouldBe true
  }

  it should "have a destroy all method" in {
    var request3 = new Request("/myurl", "goblinApp")
    Request.count shouldBe 0
    request3.save
    Request.count shouldBe 1
    Request.destroyAll
    Request.count shouldBe 0
  }


}

