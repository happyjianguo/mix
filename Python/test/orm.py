from object_test import session
import model

test_page = model.Page()
test_page.title = u'Test Page'
test_page.content = u'Test content'
print test_page.title
