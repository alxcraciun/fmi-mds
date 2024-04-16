from json import load as json_load

from scrapy.spiders import CrawlSpider,Rule
from scrapy.linkextractors import LinkExtractor

with open("scraping/scraping_strings.json","r") as f:
  strings = json_load(f)["hipo"]

class HipoSpider(CrawlSpider):
  name = "hipo"
  allowed_domains = ["hipo.ro"]
  start_urls = [strings["start_url"]]

  rules = (
    Rule(
      LinkExtractor(
        allow=(strings["allow1"],)
      )
    ),
    Rule(
      LinkExtractor(
        allow=(strings["allow2"],)
      ),
      callback="parse_item")
  )

  def parse_item(self,response):
    pass