#!/usr/bin/env python

import os
import unittest
import novaclient
import openhack

class Test(unittest.TestCase):
	


	def setUp(self, UserName, SecretKey, Project_ID):
		
		#nt = novaclient.OpenStack(AccessKey, SecretKey, Project_ID)
		
		self.oh = openhack()
		self.testuser = 'ruse1'
		self.testpass = '0a2bb2bddd3337ed02dd27f042ea73a3'
		self.testprojectid = 'ruse1-project'
		
	def can_search_instances(self):
		
		#instances = nt.list()
		
		instances = oh.searchInstances()
		self.assertTrue(element in instances)

	def can_login(self):
		
		self.assertEqual(oh.login(TestUser, TestPass, TestProject_ID), 'success')
	
	def display_instances_found(self):
		
		#can_search_instances(self)
		
		self.assertTrue(oh.displayInstances())

	def can_terminate_instances(self):

		#TODO: create assert
		#instances = nt.list()
		#s = instances[0]
		#s.suspend()

		self.assertTrue(oh.deleteInstance(0))
		
if __name__ == '__main__':
	unittest.main()
