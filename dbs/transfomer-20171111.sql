/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.50-log : Database - transfomer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_auth_menufun` */

DROP TABLE IF EXISTS `t_auth_menufun`;

CREATE TABLE `t_auth_menufun` (
  `ID` char(100) NOT NULL COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` char(40) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `MF_ID` char(40) NOT NULL COMMENT '资源id',
  `PMF_ID` char(40) DEFAULT NULL COMMENT '父资源id',
  `MF_NAME` char(200) NOT NULL COMMENT '资源名',
  `MF_LINK` char(200) DEFAULT NULL COMMENT '资源地址',
  `MF_TYPE` char(1) NOT NULL COMMENT '资源类型:0-菜单、1-功能点',
  `MF_DESC` char(200) DEFAULT NULL COMMENT '资源描述',
  `MF_RANK` char(3) DEFAULT NULL COMMENT '顺序',
  `MF_LEVEL` char(3) DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='菜单功能点表';

/*Data for the table `t_auth_menufun` */

insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','img_mgr','root','图片管理','#img-mgr','0',NULL,'1','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_deviceimg_add',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_deviceimg_add','img_mgr','设备图-新增',NULL,'1',NULL,'10','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_deviceimg_del',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_deviceimg_del','img_mgr','设备图-删除',NULL,'1',NULL,'12','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_deviceimg_edit',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_deviceimg_edit','img_mgr','设备图-编辑',NULL,'1',NULL,'11','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_deviceimg_verify',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_deviceimg_verify','img_mgr','设备图-审核',NULL,'1',NULL,'6','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_device_add',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_device_add','img_mgr','设备-新增',NULL,'1',NULL,'7','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_device_del',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_device_del','img_mgr','设备-删除',NULL,'1',NULL,'9','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_device_edit',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_device_edit','img_mgr','设备-编辑',NULL,'1',NULL,'8','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_partimg_add',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_partimg_add','img_mgr','部件图-新增',NULL,'1',NULL,'17','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_partimg_del',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_partimg_del','img_mgr','部件图-删除',NULL,'1',NULL,'19','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_partimg_edit',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_partimg_edit','img_mgr','部件图-编辑',NULL,'1',NULL,'18','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_partimg_verify',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_partimg_verify','img_mgr','部件图-审核',NULL,'1',NULL,'20','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_part_add',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_part_add','img_mgr','部件-新增',NULL,'1',NULL,'14','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_part_del',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_part_del','img_mgr','部件-删除',NULL,'1',NULL,'16','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_part_edit',NULL,'2017-11-11 10:03:54',NULL,'0000-00-00 00:00:00','img_mgr_part_edit','img_mgr','部件-编辑',NULL,'1',NULL,'15','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_view',NULL,'2017-11-11 10:07:38',NULL,'0000-00-00 00:00:00','img_mgr_view','img_mgr','查看',NULL,'1',NULL,'1','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_wg_add',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_wg_add','img_mgr','接线图-新增',NULL,'1',NULL,'3','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_wg_del',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_wg_del','img_mgr','接线图-删除',NULL,'1',NULL,'5','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_wg_edit',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_wg_edit','img_mgr','接线图-编辑',NULL,'1',NULL,'4','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_mgr_wg_verify',NULL,'2017-11-11 10:03:53',NULL,'0000-00-00 00:00:00','img_mgr_wg_verify','img_mgr','接线图-审核',NULL,'1',NULL,'6','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('img_view',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','img_view','root','图片查阅','#img-view?IS_VIEW=true','0',NULL,'2','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('root',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','root',NULL,'应用',NULL,'0',NULL,'1','0');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr','root','系统管理',NULL,'0',NULL,'3','1');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_auth','system_mgr','用户权限管理',NULL,'0',NULL,'1','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_role','system_mgr_auth','角色管理','#auth-role','0',NULL,'2','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_add',NULL,'2017-10-30 17:48:31',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_add','system_mgr_auth_role','新增',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_del',NULL,'2017-10-30 17:48:32',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_del','system_mgr_auth_role','删除',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_edit',NULL,'2017-10-30 17:48:33',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_edit','system_mgr_auth_role','编辑',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_perm',NULL,'2017-10-30 17:48:34',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_perm','system_mgr_auth_role','授权',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_search',NULL,'2017-10-30 17:48:36',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_search','system_mgr_auth_role','查询',NULL,'1',NULL,'0','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_role_view',NULL,'2017-10-30 17:48:40',NULL,'0000-00-00 00:00:00','system_mgr_auth_role_view','system_mgr_auth_role','查看',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_user','system_mgr_auth','用户管理','#auth-user','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_add',NULL,'2017-10-30 17:48:41',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_add','system_mgr_auth_user','新增',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_disable',NULL,'2017-10-30 17:48:42',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_disable','system_mgr_auth_user','禁用',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_edit',NULL,'2017-10-30 17:48:43',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_edit','system_mgr_auth_user','编辑',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_enable',NULL,'2017-10-30 17:48:44',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_enable','system_mgr_auth_user','启用',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_resetpwd',NULL,'2017-10-30 17:48:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_resetpwd','system_mgr_auth_user','重置密码',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_search',NULL,'2017-10-30 17:48:45',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_search','system_mgr_auth_user','查询',NULL,'1',NULL,'0','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_auth_user_setrole',NULL,'2017-10-30 17:48:46',NULL,'0000-00-00 00:00:00','system_mgr_auth_user_setrole','system_mgr_auth_user','分配角色',NULL,'1',NULL,'6','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config',NULL,'2017-10-30 16:35:58',NULL,'0000-00-00 00:00:00','system_mgr_config','system_mgr','系统配置',NULL,'0',NULL,'3','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config_params',NULL,'2017-10-30 16:44:51',NULL,'0000-00-00 00:00:00','system_mgr_config_params','system_mgr_config','参数配置','#system-config-params','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config_params_edit',NULL,'2017-10-30 17:52:44',NULL,'0000-00-00 00:00:00','system_mgr_config_params_edit','system_mgr_config_params','编辑',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_config_params_search',NULL,'2017-10-30 17:52:44',NULL,'0000-00-00 00:00:00','system_mgr_config_params_search','system_mgr_config_params','查询',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_dics','system_mgr','数据字典维护',NULL,'0',NULL,'2','2');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype','system_mgr_dics','设备/部件类型','#dics-devicetype','0',NULL,'2','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_add',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_add','system_mgr_dics_devicetype','新增',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_disable',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_disable','system_mgr_dics_devicetype','禁用',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_edit',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_edit','system_mgr_dics_devicetype','编辑',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_enable',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_enable','system_mgr_dics_devicetype','启用',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_devicetype_search',NULL,'2017-10-30 17:51:58',NULL,'0000-00-00 00:00:00','system_mgr_dics_devicetype_search','system_mgr_dics_devicetype','查询',NULL,'1',NULL,'1','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer',NULL,'2017-10-21 12:55:45',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer','system_mgr_dics','变电站','#dics-transformer','0',NULL,'1','3');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_add',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_add','system_mgr_dics_transformer','新增',NULL,'1',NULL,'2','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_del',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_del','system_mgr_dics_transformer','删除',NULL,'1',NULL,'6','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_disable',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_disable','system_mgr_dics_transformer','禁用',NULL,'1',NULL,'5','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_edit',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_edit','system_mgr_dics_transformer','编辑',NULL,'1',NULL,'3','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_enable',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_enable','system_mgr_dics_transformer','启用',NULL,'1',NULL,'4','4');
insert  into `t_auth_menufun`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`MF_ID`,`PMF_ID`,`MF_NAME`,`MF_LINK`,`MF_TYPE`,`MF_DESC`,`MF_RANK`,`MF_LEVEL`) values ('system_mgr_dics_transformer_search',NULL,'2017-10-30 17:50:29',NULL,'0000-00-00 00:00:00','system_mgr_dics_transformer_search','system_mgr_dics_transformer','查询',NULL,'1',NULL,'1','4');

/*Table structure for table `t_auth_rm` */

DROP TABLE IF EXISTS `t_auth_rm`;

CREATE TABLE `t_auth_rm` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `ROLE_ID` char(40) NOT NULL COMMENT '角色id',
  `MF_ID` char(40) NOT NULL COMMENT '菜单功能点id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=472 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色菜单功能点关联表';

/*Data for the table `t_auth_rm` */

insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (293,NULL,'2017-10-30 17:56:17','2','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (294,NULL,'2017-10-30 17:56:17','2','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (304,NULL,'2017-11-11 10:06:28','1','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (305,NULL,'2017-11-11 10:06:28','1','img_mgr_deviceimg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (306,NULL,'2017-11-11 10:06:28','1','img_mgr_deviceimg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (307,NULL,'2017-11-11 10:06:28','1','img_mgr_deviceimg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (308,NULL,'2017-11-11 10:06:28','1','img_mgr_deviceimg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (309,NULL,'2017-11-11 10:06:28','1','img_mgr_device_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (310,NULL,'2017-11-11 10:06:28','1','img_mgr_device_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (311,NULL,'2017-11-11 10:06:28','1','img_mgr_device_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (312,NULL,'2017-11-11 10:06:28','1','img_mgr_partimg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (313,NULL,'2017-11-11 10:06:28','1','img_mgr_partimg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (314,NULL,'2017-11-11 10:06:28','1','img_mgr_partimg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (315,NULL,'2017-11-11 10:06:28','1','img_mgr_partimg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (316,NULL,'2017-11-11 10:06:28','1','img_mgr_part_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (317,NULL,'2017-11-11 10:06:28','1','img_mgr_part_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (318,NULL,'2017-11-11 10:06:28','1','img_mgr_part_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (319,NULL,'2017-11-11 10:06:28','1','img_mgr_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (320,NULL,'2017-11-11 10:06:28','1','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (321,NULL,'2017-11-11 10:06:28','1','img_mgr_wg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (322,NULL,'2017-11-11 10:06:28','1','img_mgr_wg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (323,NULL,'2017-11-11 10:06:28','1','img_mgr_wg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (324,NULL,'2017-11-11 10:06:28','1','img_mgr_wg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (325,NULL,'2017-11-11 10:06:28','1','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (326,NULL,'2017-11-11 10:06:28','1','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (327,NULL,'2017-11-11 10:06:28','1','system_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (328,NULL,'2017-11-11 10:06:28','1','system_mgr_auth');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (329,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (330,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (331,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (332,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (333,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role_perm');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (334,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (335,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_role_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (336,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (337,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (338,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (339,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (340,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (341,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_resetpwd');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (342,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (343,NULL,'2017-11-11 10:06:28','1','system_mgr_auth_user_setrole');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (344,NULL,'2017-11-11 10:06:28','1','system_mgr_config');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (345,NULL,'2017-11-11 10:06:28','1','system_mgr_config_params');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (346,NULL,'2017-11-11 10:06:28','1','system_mgr_config_params_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (347,NULL,'2017-11-11 10:06:28','1','system_mgr_config_params_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (348,NULL,'2017-11-11 10:06:28','1','system_mgr_dics');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (349,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_devicetype');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (350,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_devicetype_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (351,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_devicetype_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (352,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_devicetype_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (353,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_devicetype_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (354,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_devicetype_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (355,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (356,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (357,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (358,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (359,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (360,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (361,NULL,'2017-11-11 10:06:28','1','system_mgr_dics_transformer_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (367,NULL,'2017-11-11 10:08:14','4','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (368,NULL,'2017-11-11 10:08:14','4','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (369,NULL,'2017-11-11 10:08:14','4','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (370,NULL,'2017-11-11 10:08:14','4','img_mgr_deviceimg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (371,NULL,'2017-11-11 10:08:14','4','img_mgr_deviceimg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (372,NULL,'2017-11-11 10:08:14','4','img_mgr_deviceimg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (373,NULL,'2017-11-11 10:08:14','4','img_mgr_part_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (374,NULL,'2017-11-11 10:08:14','4','img_mgr_part_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (375,NULL,'2017-11-11 10:08:14','4','img_mgr_part_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (376,NULL,'2017-11-11 10:08:14','4','img_mgr_partimg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (377,NULL,'2017-11-11 10:08:14','4','img_mgr_partimg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (378,NULL,'2017-11-11 10:08:14','4','img_mgr_partimg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (379,NULL,'2017-11-11 10:08:14','4','img_mgr_partimg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (380,NULL,'2017-11-11 10:08:14','4','img_mgr_wg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (381,NULL,'2017-11-11 10:08:14','4','img_mgr_wg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (382,NULL,'2017-11-11 10:08:14','4','img_mgr_wg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (383,NULL,'2017-11-11 10:08:14','4','img_mgr_deviceimg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (384,NULL,'2017-11-11 10:08:14','4','img_mgr_wg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (385,NULL,'2017-11-11 10:08:14','4','img_mgr_device_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (386,NULL,'2017-11-11 10:08:14','4','img_mgr_device_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (387,NULL,'2017-11-11 10:08:14','4','img_mgr_device_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (388,NULL,'2017-11-11 10:08:14','4','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (389,NULL,'2017-11-11 10:08:14','4','system_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (390,NULL,'2017-11-11 10:08:14','4','system_mgr_auth');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (391,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (392,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (393,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (394,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (395,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (396,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (397,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_resetpwd');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (398,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_user_setrole');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (399,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (400,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (401,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (402,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (403,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (404,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role_perm');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (405,NULL,'2017-11-11 10:08:14','4','system_mgr_auth_role_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (406,NULL,'2017-11-11 10:08:14','4','system_mgr_dics');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (407,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (408,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (409,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (410,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (411,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (412,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (413,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_transformer_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (414,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_devicetype');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (415,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_devicetype_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (416,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_devicetype_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (417,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_devicetype_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (418,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_devicetype_enable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (419,NULL,'2017-11-11 10:08:14','4','system_mgr_dics_devicetype_disable');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (420,NULL,'2017-11-11 10:08:14','4','system_mgr_config');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (421,NULL,'2017-11-11 10:08:14','4','system_mgr_config_params');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (422,NULL,'2017-11-11 10:08:14','4','system_mgr_config_params_search');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (423,NULL,'2017-11-11 10:08:14','4','system_mgr_config_params_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (446,NULL,'2017-11-11 10:08:47','3','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (447,NULL,'2017-11-11 10:08:47','3','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (448,NULL,'2017-11-11 10:08:47','3','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (449,NULL,'2017-11-11 10:08:47','3','img_mgr_deviceimg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (450,NULL,'2017-11-11 10:08:47','3','img_mgr_deviceimg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (451,NULL,'2017-11-11 10:08:47','3','img_mgr_deviceimg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (452,NULL,'2017-11-11 10:08:47','3','img_mgr_part_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (453,NULL,'2017-11-11 10:08:47','3','img_mgr_part_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (454,NULL,'2017-11-11 10:08:47','3','img_mgr_part_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (455,NULL,'2017-11-11 10:08:47','3','img_mgr_partimg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (456,NULL,'2017-11-11 10:08:47','3','img_mgr_partimg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (457,NULL,'2017-11-11 10:08:47','3','img_mgr_partimg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (458,NULL,'2017-11-11 10:08:47','3','img_mgr_wg_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (459,NULL,'2017-11-11 10:08:47','3','img_mgr_wg_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (460,NULL,'2017-11-11 10:08:47','3','img_mgr_wg_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (461,NULL,'2017-11-11 10:08:47','3','img_mgr_device_add');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (462,NULL,'2017-11-11 10:08:47','3','img_mgr_device_edit');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (463,NULL,'2017-11-11 10:08:47','3','img_mgr_device_del');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (464,NULL,'2017-11-11 10:08:47','3','img_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (465,NULL,'2017-11-11 10:09:08','5','root');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (466,NULL,'2017-11-11 10:09:08','5','img_mgr');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (467,NULL,'2017-11-11 10:09:08','5','img_mgr_view');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (468,NULL,'2017-11-11 10:09:08','5','img_mgr_partimg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (469,NULL,'2017-11-11 10:09:08','5','img_mgr_deviceimg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (470,NULL,'2017-11-11 10:09:08','5','img_mgr_wg_verify');
insert  into `t_auth_rm`(`ID`,`CREATE_USER`,`CREATE_TIME`,`ROLE_ID`,`MF_ID`) values (471,NULL,'2017-11-11 10:09:08','5','img_view');

/*Table structure for table `t_auth_role` */

DROP TABLE IF EXISTS `t_auth_role`;

CREATE TABLE `t_auth_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` int(11) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` int(11) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `ROLE_NAME` char(40) NOT NULL COMMENT '角色名',
  `ROLE_DESC` char(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `t_auth_role` */

insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (1,NULL,'2017-10-24 17:35:17',1,'2017-10-24 17:35:17','超级管理员（勿删除）','所有权限');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (2,1,'2017-10-24 17:34:58',1,'2017-10-24 17:34:58','图片查阅人员','图片查阅');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (3,1,'2017-10-24 17:34:40',1,'2017-10-24 17:34:40','图片管理编辑人员','图片管理、查阅');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (4,1,'2017-10-24 17:35:07',1,'2017-10-24 17:35:07','系统管理员','系统管理');
insert  into `t_auth_role`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`ROLE_NAME`,`ROLE_DESC`) values (5,1,'2017-11-11 10:09:21',1,'2017-11-11 10:09:21','图片管理审核人员','图片审核、查阅');

/*Table structure for table `t_auth_ur` */

DROP TABLE IF EXISTS `t_auth_ur`;

CREATE TABLE `t_auth_ur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户id',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

/*Data for the table `t_auth_ur` */

insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (1,NULL,'2017-09-13 14:45:37',1,1);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (4,'1','2017-10-22 09:47:19',2,2);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (5,'1','2017-10-22 10:05:24',5,4);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (6,'1','2017-10-22 10:05:29',4,3);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (7,'1','2017-10-22 10:05:34',3,2);
insert  into `t_auth_ur`(`ID`,`CREATE_USER`,`CREATE_TIME`,`USER_ID`,`ROLE_ID`) values (8,'1','2017-10-24 17:34:22',6,5);

/*Table structure for table `t_auth_user` */

DROP TABLE IF EXISTS `t_auth_user`;

CREATE TABLE `t_auth_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATE_USER` char(40) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` char(40) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `LOGIN_NAME` char(40) NOT NULL COMMENT '登录名',
  `NAME` char(40) NOT NULL COMMENT '姓名',
  `PASS_WORD` char(80) NOT NULL COMMENT '密码',
  `IS_USED` char(2) DEFAULT '01' COMMENT '01:有效，02：无效',
  `EMAIL` char(100) DEFAULT NULL COMMENT '邮箱',
  `SEX` char(2) DEFAULT NULL COMMENT '性别',
  `PHONE` char(100) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `t_auth_user` */

insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (1,NULL,'2017-09-15 15:50:04','1','2017-09-15 15:50:04','admin','管理员','DD4B21E9EF71E1291183A46B913AE6F2','01',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (3,'1','2017-10-22 10:04:47',NULL,'2017-10-22 10:04:47','chakan','图片查看测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (4,'1','2017-10-22 10:05:07',NULL,'2017-10-22 10:05:07','tupianguanli','图片管理测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (5,'1','2017-10-24 17:30:35','1','2017-10-24 17:30:35','xitongguanli','系统管理测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);
insert  into `t_auth_user`(`ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`,`LOGIN_NAME`,`NAME`,`PASS_WORD`,`IS_USED`,`EMAIL`,`SEX`,`PHONE`) values (6,'1','2017-10-24 17:34:15',NULL,'2017-10-24 17:34:15','tupianshenhe','图片审核测试人员','DD4B21E9EF71E1291183A46B913AE6F2','1',NULL,NULL,NULL);

/*Table structure for table `t_base_dics` */

DROP TABLE IF EXISTS `t_base_dics`;

CREATE TABLE `t_base_dics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_type` varchar(40) NOT NULL COMMENT '码表类型',
  `code_value` varchar(50) NOT NULL COMMENT '码值',
  `code_desc` varchar(200) NOT NULL COMMENT '码值描述',
  `is_use` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否启用：0-否，1-是',
  `rank` int(11) DEFAULT NULL COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='公共码表';

/*Data for the table `t_base_dics` */

insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (135,'common.yesno','0','否','1',2);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (136,'common.yesno','1','是','1',1);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (137,'common.verify','0','待审核','1',1);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (138,'common.verify','1','审核通过','1',2);
insert  into `t_base_dics`(`id`,`code_type`,`code_value`,`code_desc`,`is_use`,`rank`) values (139,'common.verify','9','审核未通过','1',3);

/*Table structure for table `t_base_dics_type` */

DROP TABLE IF EXISTS `t_base_dics_type`;

CREATE TABLE `t_base_dics_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(40) NOT NULL COMMENT '字典类型编码',
  `type_desc` varchar(100) NOT NULL COMMENT '字典类型描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_base_dics_type` */

/*Table structure for table `t_biz_device` */

DROP TABLE IF EXISTS `t_biz_device`;

CREATE TABLE `t_biz_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '设备名',
  `type_id` int(11) DEFAULT NULL COMMENT '设备类型',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `wiringdiagram_id` int(11) NOT NULL COMMENT '接线图id',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `x` int(11) DEFAULT NULL COMMENT '坐标-x',
  `y` int(11) DEFAULT NULL COMMENT '坐标-y',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备';

/*Data for the table `t_biz_device` */

insert  into `t_biz_device`(`id`,`name`,`type_id`,`desc`,`wiringdiagram_id`,`img_id`,`x`,`y`,`width`,`height`,`create_user`,`create_time`) values (6,'岳#21',9,'',5,NULL,135,365,100,100,'1','2017-11-11 13:58:11');

/*Table structure for table `t_biz_device_img` */

DROP TABLE IF EXISTS `t_biz_device_img`;

CREATE TABLE `t_biz_device_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) NOT NULL COMMENT '图片id',
  `device_id` int(11) NOT NULL COMMENT '设备id',
  `verify_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '审核状态：0-待审核，1-审核通过，9审核不通过',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_user` varchar(100) DEFAULT NULL COMMENT '审核人',
  `verify_content` varchar(500) DEFAULT NULL COMMENT '审核结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='设备图';

/*Data for the table `t_biz_device_img` */

insert  into `t_biz_device_img`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`device_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (5,'濮会3开关（HGIS）','2017-11-11 13:59:06','1','c14025cf-ffbf-4f18-bf9e-80c0291a10bc',6,'0',NULL,NULL,NULL);

/*Table structure for table `t_biz_device_type` */

DROP TABLE IF EXISTS `t_biz_device_type`;

CREATE TABLE `t_biz_device_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '类型名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `state` varchar(2) NOT NULL DEFAULT '01' COMMENT '状态：01-可用，02-禁用',
  `par_id` int(11) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备类型';

/*Data for the table `t_biz_device_type` */

insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`,`par_id`) values (8,'测试设备类型','2017-11-11 13:57:48','1','01',NULL);
insert  into `t_biz_device_type`(`id`,`name`,`create_time`,`create_user`,`state`,`par_id`) values (9,'开关','2017-11-11 13:57:58','1','01',8);

/*Table structure for table `t_biz_files` */

DROP TABLE IF EXISTS `t_biz_files`;

CREATE TABLE `t_biz_files` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `filename_src` varchar(200) NOT NULL COMMENT '文件名-原始',
  `filename_new` varchar(200) NOT NULL COMMENT '文件名-新',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `create_user` varchar(100) NOT NULL COMMENT '上传人',
  `path` varchar(200) NOT NULL COMMENT '文件存储路径-相对',
  `filetype` varchar(50) NOT NULL COMMENT '文件类型',
  `filesize` double NOT NULL COMMENT '文件大小：单位kb',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='附件表';

/*Data for the table `t_biz_files` */

insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('2d1b4dc8-5feb-4a67-b9dc-27a454a978d5','濮会3（HGIS）-2.JPG','2d1b4dc8-5feb-4a67-b9dc-27a454a978d5.JPG','2017-11-11 13:59:49','1','parthis\\2017-11-11\\2d1b4dc8-5feb-4a67-b9dc-27a454a978d5.JPG','JPG',4472);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('5bdabb4e-1948-4b50-b184-3245749ac2bf','岳村站一次系统图（10kV）.png','5bdabb4e-1948-4b50-b184-3245749ac2bf.png','2017-11-11 13:56:50','1','wg\\2017-11-11\\5bdabb4e-1948-4b50-b184-3245749ac2bf.png','png',122);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('c14025cf-ffbf-4f18-bf9e-80c0291a10bc','濮会3（HGIS）.JPG','c14025cf-ffbf-4f18-bf9e-80c0291a10bc.JPG','2017-11-11 13:59:03','1','deviceimg\\2017-11-11\\c14025cf-ffbf-4f18-bf9e-80c0291a10bc.JPG','JPG',4123);
insert  into `t_biz_files`(`id`,`filename_src`,`filename_new`,`create_time`,`create_user`,`path`,`filetype`,`filesize`) values ('c53815af-e004-4fb3-bdd5-d73ddf9e41fe','岳村站一次系统图（220kV 110kV）.png','c53815af-e004-4fb3-bdd5-d73ddf9e41fe.png','2017-11-11 13:55:02','1','wg\\2017-11-11\\c53815af-e004-4fb3-bdd5-d73ddf9e41fe.png','png',183);

/*Table structure for table `t_biz_part` */

DROP TABLE IF EXISTS `t_biz_part`;

CREATE TABLE `t_biz_part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '部件名称',
  `desc` varchar(500) DEFAULT NULL COMMENT '部件描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `x` int(11) DEFAULT NULL COMMENT '坐标-x',
  `y` int(11) DEFAULT NULL COMMENT '坐标-y',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `type_id` int(11) NOT NULL COMMENT '部件类型',
  `device_img_id` int(11) NOT NULL COMMENT '设备图id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备部件';

/*Data for the table `t_biz_part` */

insert  into `t_biz_part`(`id`,`name`,`desc`,`create_time`,`create_user`,`img_id`,`x`,`y`,`width`,`height`,`type_id`,`device_img_id`) values (5,'电线','','2017-11-11 13:59:29','1',NULL,199,188,100,100,9,5);

/*Table structure for table `t_biz_part_his` */

DROP TABLE IF EXISTS `t_biz_part_his`;

CREATE TABLE `t_biz_part_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) DEFAULT NULL COMMENT '图片id',
  `content` text NOT NULL COMMENT '内容',
  `part_id` int(11) NOT NULL COMMENT '部件id',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '审核状态',
  `verify_user` varchar(100) DEFAULT NULL COMMENT '审核人',
  `verify_content` varchar(500) DEFAULT NULL COMMENT '审核内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='部件历史';

/*Data for the table `t_biz_part_his` */

insert  into `t_biz_part_his`(`id`,`create_time`,`create_user`,`img_id`,`content`,`part_id`,`verify_time`,`verify_status`,`verify_user`,`verify_content`) values (18,'2017-11-11 13:59:51','1','2d1b4dc8-5feb-4a67-b9dc-27a454a978d5','电线1的日志',5,'2017-11-11 14:00:12','1','1','还可以');

/*Table structure for table `t_biz_transformer` */

DROP TABLE IF EXISTS `t_biz_transformer`;

CREATE TABLE `t_biz_transformer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL COMMENT '名称',
  `type` varchar(200) NOT NULL COMMENT '分类',
  `desc` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `state` varchar(2) NOT NULL DEFAULT '01' COMMENT '状态：01-可用，02-禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='变电站';

/*Data for the table `t_biz_transformer` */

insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (5,'岳村站','公司属变电站','岳村站','1','2017-11-11 13:53:48',NULL,'01');
insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (6,'尧舜站','公司属变电站','尧舜','1','2017-11-11 13:54:02',NULL,'01');
insert  into `t_biz_transformer`(`id`,`name`,`type`,`desc`,`create_user`,`create_time`,`address`,`state`) values (7,'变电站C','用户属变电站','变电站C的描述','1','2017-11-11 13:54:13',NULL,'01');

/*Table structure for table `t_biz_wiringdiagram` */

DROP TABLE IF EXISTS `t_biz_wiringdiagram`;

CREATE TABLE `t_biz_wiringdiagram` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(100) NOT NULL COMMENT '创建人',
  `img_id` varchar(100) NOT NULL COMMENT '图片id',
  `transformer_id` int(11) NOT NULL COMMENT '变电站id',
  `verify_status` varchar(2) NOT NULL DEFAULT '0' COMMENT '审核状态：0-待审核，1-审核通过，9审核不通过',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_user` varchar(100) DEFAULT NULL COMMENT '审核人',
  `verify_content` varchar(500) DEFAULT NULL COMMENT '审核结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='接线图';

/*Data for the table `t_biz_wiringdiagram` */

insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (4,'岳村站一次系统图（220kV 110kV）','2017-11-11 13:55:04','1','c53815af-e004-4fb3-bdd5-d73ddf9e41fe',5,'0',NULL,NULL,NULL);
insert  into `t_biz_wiringdiagram`(`id`,`desc`,`create_time`,`create_user`,`img_id`,`transformer_id`,`verify_status`,`verify_time`,`verify_user`,`verify_content`) values (5,'岳村站一次系统图（10kV）','2017-11-11 13:56:52','1','5bdabb4e-1948-4b50-b184-3245749ac2bf',5,'1','2017-11-11 14:01:44','6','不错啊');

/*Table structure for table `t_system_config` */

DROP TABLE IF EXISTS `t_system_config`;

CREATE TABLE `t_system_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user` varchar(100) NOT NULL COMMENT '更新时间',
  `module_id` varchar(50) NOT NULL COMMENT '模块id',
  `module_desc` varchar(200) NOT NULL COMMENT '模块描述',
  `type` varchar(50) NOT NULL COMMENT '类型:1-文字，2-图片',
  `key` varchar(200) NOT NULL COMMENT '唯一类型',
  `content` text NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_system_config` */

/* Function  structure for function  `getDeviceTypeNameById` */

/*!50003 DROP FUNCTION IF EXISTS `getDeviceTypeNameById` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getDeviceTypeNameById`(device_id INT) RETURNS varchar(200) CHARSET utf8
BEGIN
	DECLARE ret VARCHAR(200);
	DECLARE done INT DEFAULT FALSE;
	DECLARE cur CURSOR FOR SELECT `name` FROM t_biz_device_type WHERE id=customer_id;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	OPEN cur;
		FETCH cur INTO ret;
	CLOSE cur;
	RETURN ret;
    END */$$
DELIMITER ;

/* Function  structure for function  `getDicValue` */

/*!50003 DROP FUNCTION IF EXISTS `getDicValue` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getDicValue`(cv VARCHAR(100), ct VARCHAR(40)) RETURNS varchar(200) CHARSET utf8
BEGIN
     DECLARE ret VARCHAR(200);
     DECLARE done INT DEFAULT FALSE;
     DECLARE cur CURSOR  FOR SELECT code_desc FROM t_base_dics WHERE code_type = ct AND code_value = cv;
     DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;        
     OPEN cur;
         FETCH cur INTO ret;
      CLOSE cur;
     RETURN ret;
    END */$$
DELIMITER ;

/* Function  structure for function  `getusername` */

/*!50003 DROP FUNCTION IF EXISTS `getusername` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getusername`(userid VARCHAR(100)) RETURNS varchar(200) CHARSET utf8
BEGIN
	DECLARE ret VARCHAR(200);
	DECLARE done INT DEFAULT FALSE;
	DECLARE cur CURSOR  FOR SELECT `name` FROM t_auth_user WHERE id = userid;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;		
	SET ret = '';
	OPEN cur;
		FETCH cur INTO ret;
	 CLOSE cur;
	RETURN ret;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
