package com.moonrakerAnalytics.app

import org.scalatest._

class ResponseSpec extends FlatSpec with Matchers {
  def response = new Response(Map("status" -> 200, "body" -> "Success!"))

  it should "be a response" in {
    response shouldBe a [Response]
  }

  it should "return the status" in {
    response.status shouldBe 200
  }

  it should "return the body" in {
    response.body shouldBe "Success!"
  }

  it should "return the default status" in {
    val emtpy_status_response = new Response(Map("status" -> null, "body" -> "Failure."))
    emtpy_status_response.status shouldBe 200
  }

  it should "return the default body" in {
    val emtpy_body_response = new Response(Map("status" -> 404, "body" -> null))
    emtpy_body_response.body shouldBe ""
  }

}

//