package com.moonrakerAnalytics.app

import org.scalatest._

class SourcesControllerSpec extends FlatSpec with Matchers {

  def params = "{\"payload\" => \"{\"url\":\"http://jumpstartlab.com/blog\",\"requestedAt\":\"2013-02-16 21:38:28 -0700\",\"respondedIn\":37,\"referredBy\":\"http://jumpstartlab.com\",\"requestType\":\"GET\",\"parameters\":[],\"eventName\": \"socialLogin\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17\",\"resolutionWidth\":\"1920\",\"resolutionHeight\":\"1280\",\"ip\":\"63.29.38.211\" }\",\"application\" => \"JetFuelExpress\"}"

  it should "accept parameters" in {
    Source.destroyAll
    Source.count shouldBe 0
    val acceptParamsResponse = SourcesController.create(Map("identifier" -> "hello there", "rootUrl" -> "worldly people"))
    acceptParamsResponse.body shouldBe "Created source hello there for url worldly people."
    Source.all.length shouldBe 1
    Source.destroyAll
  }

  it should "have return a response on valid save" in {
    Source.destroyAll
    val result = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))
    result.status shouldBe 200
    result.body shouldBe "Created source jetfuelexpress for url jfx.herokuapp.com."
    Source.destroyAll
  }

  it should "reject a duplicate source with a 403" in {
    Source.destroyAll
    val result2 = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))
    val result3 = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> "jfx.herokuapp.com"))
    result3.status shouldBe 403
    result3.body shouldBe "Sorry, the id or url you requested has already been taken."
    Source.destroyAll
  }

  it should "return 400 and a message when missing the identifier" in {
    Source.destroyAll
    val result4 = SourcesController.create(Map("identifier" -> null, "rootUrl" -> "jfx.herokuapp.com"))
    result4.status shouldBe 400
    result4.body shouldBe "Missing identifier parameter"
    Source.destroyAll
  }

  it should "return 400 and a message when missing the rootUrl" in {
    Source.destroyAll
    val result5 = SourcesController.create(Map("identifier" -> "jetfuelexpress", "rootUrl" -> null))
    result5.status shouldBe 400
    result5.body shouldBe "Missing rootUrl parameter"
    Source.destroyAll
  }

}
