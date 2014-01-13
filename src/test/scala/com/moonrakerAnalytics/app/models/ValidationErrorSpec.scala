package com.moonrakerAnalytics.app

import org.scalatest._

class ValidationErrorSpec extends FlatSpec with Matchers {
  def validationError = new ValidationError(Map("category" -> "invalid parameter", "message" -> "Parameter is invalid."))

  it should "be a validation error" in {
    validationError shouldBe a [ValidationError]
  }

  it should "have a category" in {
    validationError.category shouldBe "invalid parameter"
  }

  it should "have a message" in {
    validationError.message shouldBe "Parameter is invalid."
  }

}

