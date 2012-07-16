import novaclient
import os
import unittest
from Infrastructure import instances

def TestMetadata
    def setUp(self):
        self.credentials = {'username': 'ruse1', 'apikey': '0a2bb2bddd3337ed02dd27f042ea73a3',
                            'projectid': 'ruse1-project', 'apikey': '0a2bb2bddd3337ed02dd27f042ea73a3',
                            'url': 'http://alpha.auth.api.rackspacecloud.com:5000/v2.0/', 'region': 'ORD',
                            'version': '1.1'}
        self.oh = manage_instances()
		self.metaKeyTrue='testtrue'

	def test_metadata(self):
		instances = manage_instances.search_for_instances(self.oh)
		manage_instances.remove_without_meta(metaKeyTrue)
		for i in range(1..len(instances))
			assertFalse(instance[i].equalsMeta(self.metaKeyTrue))
	
	