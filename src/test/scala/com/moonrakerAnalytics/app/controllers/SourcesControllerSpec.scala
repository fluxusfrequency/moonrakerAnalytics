package com.moonrakerAnalytics.app

import org.scalatest._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class SourcesControllerSpec extends FlatSpec with Matchers {
  val params = "{\"payload\" => \"{\"url\":\"http://jumpstartlab.com/blog\",\"requestedAt\":\"2013-02-16 21:38:28 -0700\",\"respondedIn\":37,\"referredBy\":\"http://jumpstartlab.com\",\"requestType\":\"GET\",\"parameters\":[],\"eventName\": \"socialLogin\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17\",\"resolutionWidth\":\"1920\",\"resolutionHeight\":\"1280\",\"ip\":\"63.29.38.211\" }\",\"application\" => \"JetFuelExpress\"}"

  // xit should "accept parameters" in {
  //   SourcesController.create() should not raiseError
  // }

  // xit should "have an identifier and a rootUrl" in {
  //   val source = Source.create("identifier" => "jetfuelexpress", "rootUrl" => "jfx.herokuapp.com")
  //   source.status should be 200
  //   source.body should include "Created jetfuelexpress source for url jfx.herokuapp.com"
  // }

  // xit should "reject a duplicate source" in {
  //   val source1 = Source.create("identifier" => "jetfuelexpress", "rootUrl" => "jfx.herokuapp.com")
  //   val source2 = Source.create("identifier" => "jetfuelexpress", "rootUrl" => "jfx.herokuapp.com")
  //   source2.status should be 403
  //   source2.body should include "Sorry, this identifier has already been taken."
  // }

  // xit should "return 400 and a message when missing the identifier" in {
  //   val source = Source.create("rootUrl" => "jfx.herokuapp.com")
  //   source.status should be 400
  //   source.body should include "Missing identifier parameter."
  // }

  // xit should "return 400 and a message when missing the rootUrl" in {
  //   val source = Source.create("identifier" => "jetfuelexpress")
  //   source.status should be 400
  //   source.body should include "Missing rootUrl parameter."
  // }

}
