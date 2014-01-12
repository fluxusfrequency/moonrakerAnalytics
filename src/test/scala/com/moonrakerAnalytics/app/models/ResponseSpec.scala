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
    emtpy_status_response = Response.new(null, "Failure.")
    emtpy_status_response.status should be 200
  }

  it should "have a body" in {
    response.source shouldBe "Success!"
  }

  it should "return the default status" in {
    emtpy_body_response = Response.new(400, null)
    emtpy_body_response.body should be ""
  }

}

