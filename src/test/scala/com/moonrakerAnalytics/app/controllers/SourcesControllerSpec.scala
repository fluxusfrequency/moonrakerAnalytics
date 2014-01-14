package com.moonrakerAnalytics.app

import org.scalatest._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class SourcesControllerSpec extends FlatSpec with Matchers {
  val params = "{\"payload\" => \"{\"url\":\"http://jumpstartlab.com/blog\",\"requestedAt\":\"2013-02-16 21:38:28 -0700\",\"respondedIn\":37,\"referredBy\":\"http://jumpstartlab.com\",\"requestType\":\"GET\",\"parameters\":[],\"eventName\": \"socialLogin\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17\",\"resolutionWidth\":\"1920\",\"resolutionHeight\":\"1280\",\"ip\":\"63.29.38.211\" }\",\"application\" => \"JetFuelExpress\"}"

  it should "accept parameters" in {
    Source.count shouldBe 0
    SourcesController.create(Map("identifier" -> "hello", "rootUrl" -> "world"))
    Source.count shouldBe 1
    Source.destroyAll
  }

  it should "have return a response on valid save" in {
    val result = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))
    result.status shouldBe 200
    result.body shouldBe "Created source jetfuelexpress for url jfx.herokuapp.com."
  }

  it should "reject a duplicate source with a 403" in {
    val result = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))
    val result2 = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))
    result2.status shouldBe 403
    result2.body shouldBe "Sorry, the id or url you requested has already been taken."
  }

  it should "return 400 and a message when missing the identifier" in {
    val result = SourcesController.create(Map("identifier" -> null, "rootUrl" -> "jfx.herokuapp.com"))
    result.status shouldBe 400
    result.body shouldBe "Missing identifier parameter"
  }

  it should "return 400 and a message when missing the rootUrl" in {
    val result = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> null))
    result.status shouldBe 400
    result.body shouldBe "Missing rootUrl parameter"
  }

}
