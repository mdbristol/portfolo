import novaclient
import os
import unittest
import logging.Logger

class LoggingTestCase(unittest.TestCase):
    """OpenHack logging tests"""
    def setUp(self):
        self.testuser = 'ruse1'
        self.testpass = '0a2bb2bddd3337ed02dd27f042ea73a3'
        self.testprojectid = 'ruse1-project'
        self.testapikey = '0a2bb2bddd3337ed02dd27f042ea73a3'
        self.testurl = 'http://alpha.auth.api.rackspacecloud.com:5000/v2.0/'
        self.oh = manage_instances()

    def test_log_disclaimer_accepted(self):

        def fake_disclaimer_response(*args, **kwargs):
            return True

        logfiles = os.listdir('openhack/logs')
        self.stubs.Set('disclaimer_response',fake_disclaimer_response)
        self.AssertTrue('disclaimer_response.log' in logfiles)

    def test_open_log(self):

        def fake_open_log(*args, **kwargs)
            return open('openhack/logs/disclaimer_response.log', 'r')
        self.stubs.Set('open_log', fake_open_log)
      #  self.Assert

    def test_open_log_with_invalid_path(self):

        def fake_open_log(*args, **kwargs):
            return 'File Not Found'
        invalid_file = open_log('dog/dj/mom.log')
        self.stubs.Set('open_log', fake_open_log)
        self.AssertEqual(invalid_file, 'File Not Found')


class DeleteInstancesTestCase(unittest.TestCase):
    """Tests for deleting an instance"""
    def setUp(self):
         self.testuser = 'ruse1'
         self.testpass = '0a2bb2bddd3337ed02dd27f042ea73a3'
         self.testprojectid = 'ruse1-project'
         self.testapikey = '0a2bb2bddd3337ed02dd27f042ea73a3'
         self.testurl = 'http://alpha.auth.api.rackspacecloud.com:5000/v2.0/'
         self.oh = manage_instances()
		 
	def test_delete_instance(self):
        server = "Demo"
        def fake_list(*args, **kwargs):
            fake_servers = ['elem1', 'elem2', server]
            return fake_servers

        self.stubs("search_for_instances", fake_list)
        server_delete(server)
        self.assertNotIn(server,fake_servers)

    def test_output_success(self):
        def fake_delete(*args, **kwargs):
            deleted = True
            return deleted

        self.stubs("server_delete", fake_delete)
        self.assertTrue(deleted)

    def test_output_failure(self):
        def fake_delete(*args, **kwargs):
            deleted = False
            return deleted

        self.stubs("server_delete", fake_delete)
        self.assertNotTrue(deleted)
                                                 
