package com.moonrakerAnalytics.app

object Action {
  val tableName = 0
  val attributes = Seq("id", "requested_at", "responded_in", "request_type",
                       "parameters", "digest", "source_id", "url_id",
                       "user_agent_id", "resolution_id", "ip_id", "referrer_id",
                       "event_id")
  def runQuery {}
  def urls {}
  def browsers {}
  def oss {}
  def resolutions {}
  def averageUrlResponseTime {}
  def responseTimeForPath {}
  def eventOccurranceByHour {}
  def eventCount {}
  def eventsSubset {}
}
