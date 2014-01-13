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
    request.exists shouldBe true
  }

  it should "have a save method" in {
    pending
    request.save
  }

  it should "check the equality of data and source" in {
    pending
    request.areEqual
  }

  it should "have a destroy all method" in {
    pending
    request.destroyAll
  }
}

