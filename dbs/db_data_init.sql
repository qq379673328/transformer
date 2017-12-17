DELETE FROM `t_biz_device`;
DELETE FROM `t_biz_device_img`;
DELETE FROM `t_biz_device_type`;
DELETE FROM `t_biz_files`;
DELETE FROM `t_biz_part`;
DELETE FROM `t_biz_part_his`;
DELETE FROM `t_biz_transformer`;
DELETE FROM `t_biz_wiringdiagram`;
DELETE FROM `t_system_config`;
DELETE FROM `t_log_visit`;
INSERT  INTO `t_system_config`(`id`,`update_time`,`update_user`,`module_id`,`module_desc`,`type`,`key`,`content`) VALUES (1,'2017-10-30 17:59:55','1','index','首页','1','左侧文字','濮阳市变电站简介。\n    （请到系统管理-参数配置页面修改内容）');
INSERT  INTO `t_system_config`(`id`,`update_time`,`update_user`,`module_id`,`module_desc`,`type`,`key`,`content`) VALUES (2,'2017-10-30 22:29:16','1','index','首页','2','右侧图片','e03c5c7f-d420-4d43-a05d-e54acc3dc1ee');

COMMIT;
