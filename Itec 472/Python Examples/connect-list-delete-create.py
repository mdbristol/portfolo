import novaclient
from novaclient.v1_1 import client
nt = client.Client('ruse1',
			'0a2bb2bddd3337ed02dd27f042ea73a3', 
			'ruse1-project', 
			'http://alpha.auth.api.rackspacecloud.com:5000/v2.0/'
			)
servers = nt.servers.list()

servers[0].delete()
#nt.servers.create(NAME, IMAGE, FLAVOR)
nt.servers.create('test-python', '46fd71bf-f11b-4052-8821-5c37db30fbfd', 5)

