<?php
/**
 * The base configurations of the WordPress.
 *
 * This file has the following configurations: MySQL settings, Table Prefix,
 * Secret Keys, WordPress Language, and ABSPATH. You can find more information
 * by visiting {@link http://codex.wordpress.org/Editing_wp-config.php Editing
 * wp-config.php} Codex page. You can get the MySQL settings from your web host.
 *
 * This file is used by the wp-config.php creation script during the
 * installation. You don't have to use the web site, you can just copy this file
 * to "wp-config.php" and fill in the values.
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define('DB_NAME', 'softeng12');

/** MySQL database username */
define('DB_USER', 'softeng12');

/** MySQL database password */
define('DB_PASSWORD', 'TTgods2011');

/** MySQL hostname */
define('DB_HOST', 'localhost');

/** Database Charset to use in creating database tables. */
define('DB_CHARSET', 'utf8');

/** The Database Collate type. Don't change this if in doubt. */
define('DB_COLLATE', '');

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'A}Z]7w>DSdOAFjhAH7S,i^[./33BshSFdb7H_fC&<j2a=`g~I-+[RaW&>a~E/f_0');
define('SECURE_AUTH_KEY',  'tGh]^uOg(*9aBN26^d(UeiK[{u3/E_$zdyP15X;;8JeJWd]F[WWQF@m2e`6pl~jF');
define('LOGGED_IN_KEY',    'STA>yCp/yzzg0o<8uF:Ca=QWa3W%3kBTNL-4wPu/FUAYD<g1$s>df2|G70V|8Z,s');
define('NONCE_KEY',        'J=Q+KtDYTr,-HZ;2~;XT:CSRH`vpN]l] D}h0])@O]bAxhh9AfV5X()`*4R.;6.K');
define('AUTH_SALT',        '{pqUdfo9<-!A./0])!,a@B[E3r2YfH/&@y?8TZd+eAb{DCe!H1+p_FTqx1to|?Dx');
define('SECURE_AUTH_SALT', ':.Z*;8z?&T&>aDQFk|<uxiyWq+eBuHp]w-SX/f|J61t[gVS)Ny`}z{6]$Zy4O@7s');
define('LOGGED_IN_SALT',   ',6s/tURHS$4WXzLS?E)RjvTjg},al-6te8}Q4TM2<?CTY]Bs$wtR]JxjwK:h]EC]');
define('NONCE_SALT',       'LmK)06*ja]FityB@O@(-RH#PIZE?;seJNk/PdCEc[@qAIGZ.O#H+Fm<_AsIL=P3j');

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each a unique
 * prefix. Only numbers, letters, and underscores please!
 */
$table_prefix  = 'wp_';

/**
 * WordPress Localized Language, defaults to English.
 *
 * Change this to localize WordPress. A corresponding MO file for the chosen
 * language must be installed to wp-content/languages. For example, install
 * de_DE.mo to wp-content/languages and set WPLANG to 'de_DE' to enable German
 * language support.
 */
define('WPLANG', '');

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 */
define('WP_DEBUG', false);

/* That's all, stop editing! Happy blogging. */

/** Absolute path to the WordPress directory. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Sets up WordPress vars and included files. */
require_once(ABSPATH . 'wp-settings.php');
