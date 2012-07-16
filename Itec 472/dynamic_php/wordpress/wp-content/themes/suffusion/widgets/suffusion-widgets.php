<?php
/**
 * Loads up all the widgets defined by Suffusion. This functionality will be released as a plugin in a future release.
 *
 * @package Suffusion
 * @subpackage Widgets
 */

if (!class_exists('Suffusion_Widgets')) {
	class Suffusion_Widgets {
		function Suffusion_Widgets() {
			include_once (TEMPLATEPATH . '/widgets/suffusion-search.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-meta.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-twitter.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-query-posts.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-featured-posts.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-translator.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-subscription.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-flickr.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-query-users.php');
			include_once (TEMPLATEPATH . '/widgets/suffusion-child-pages.php');
		}

		function init() {
			add_action("widgets_init", array(&$this, "load_widgets"));
		}

		function load_widgets() {
			register_widget("Suffusion_Search");
			register_widget("Suffusion_Meta");
			register_widget("Suffusion_Follow_Twitter");
			register_widget("Suffusion_Category_Posts");
			register_widget("Suffusion_Featured_Posts");
			register_widget("Suffusion_Google_Translator");
			register_widget("Suffusion_Subscription");
			register_widget("Suffusion_Flickr");
			register_widget("Suffusion_Query_Users");
			register_widget("Suffusion_Child_Pages");
		}
	}
}
?>