package com.moonrakerAnalytics.app

import org.scalatest._

class RequestSpec extends FlatSpec with Matchers {
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

  it should "have a save method" in {
    pending
    request.save
    Request.exists(request) shouldBe true
  }

  it should "have a destroy all method" in {
    Request.count shouldBe 0
    request.save
    Request.count shouldBe 1
    Request.destroyAll
    Request.count shouldBe 0
  }
}

