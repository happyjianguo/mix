# from pyelasticsearch import ElasticSearch
#
# es = ElasticSearch('http://localhost:9200/')
#
# es.index('contacts', 'person', {'name': 'Joe Tester', 'age': 25, 'title': 'QA Master'}, id=1)
# docs = [{'id': 2, 'name': 'Jessica Coder', 'age': 32, 'title': 'Programmer'},
#         {'id': 3, 'name': 'Freddy Tester', 'age': 29, 'title': 'Office Assistant'}]
# es.bulk_index(docs=docs, index='contacts', doc_type='person')
#
# es.refresh('contacts')
#
# # query={'query':{
# # 'filtered':{
# #         'query':{
# #             'query_string':{'query':'name:Jessica'}
# #         }
# #     }
# # }}
# query = {'query': {
#     'bool': {
#         # "must": {
#         #     "match": {
#         #         "name": "Joe"
#         #     }
#         # },
#         "should":{
#             "range":{
#                 "id":{"from":1,"to":3}
#             }
#         }
#     }
# }}
# print(es.search(query, index='contacts'))
from pyelasticsearch import ElasticSearch
import json


es = ElasticSearch('http://10.97.192.86:9200/')
search_string='{"where":{"must":{"phone":"5"},"should":{"come_from":"69"}},"limit":20,"offset":0,"fields":["orderId","rstNumber"]}'

jsonObj = json.loads(search_string)
if jsonObj.has_key("limit"):
    limit = jsonObj['limit']
else:
    limit = 30
if jsonObj.has_key("offset"):
    offset = jsonObj['offset']
else:
    offset = 0
fields = jsonObj['fields']
where = jsonObj['where']
for key,value in where.item():
    print key

# print es.search(queryString, index='index')