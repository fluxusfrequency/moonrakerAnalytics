package com.moonrakerAnalytics.app

object Event {
  val tableName = "events"
  val attributes = Seq("id", "eventName", "sourceId")
  def createFromSource {}
  def eventsFromSource {}
  def eventCounts {}
  def validate {}
  def manyNew {}
  def manySave {}
}
