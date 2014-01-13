package com.moonrakerAnalytics.app

import org.scalatest._

class ResponseSpec extends FlatSpec with Matchers {
  def response = new Response(200, "Success!")

  it should "be a response" in {
    response shouldBe a [Response]
  }

  it should "return the status" in {
    response.status shouldBe 200
  }

  it should "return the default status" in {
    pending
    // emtpy_status_response = new Response(null, "Failure.")
    // emtpy_status_response.status shouldBe 400
  }

  it should "have a body" in {
    response.body shouldBe "Success!"
  }

  it should "return the default body" in {
    pending
    // emtpy_body_response = Response.new(400, null)
    // emtpy_body_response.body shouldBe ""
  }

}

