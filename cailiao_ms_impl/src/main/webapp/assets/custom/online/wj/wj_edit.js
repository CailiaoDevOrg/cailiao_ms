(function($) {

	$(function() {

		// 加载数据
		loadData();

		function loadData() {
			var wjId = $('#wjId').val();
            $.ajax({
	            url: '/online/wj/detail/' + wjId + '.html',
	            method: 'GET',
	            contentType: 'application/json',
	            success: function(data) {
	            	data = JSON.parse(data);
	            	if (data.retCode == 200) {
	                    _renderData(data);
	            	} else {
	            		alert('系统忙，加载数据失败');
	            	}
	            },
	            error: function(data) {
	            	alert('网络出现问题，加载数据失败');
	            }
	        });
		}

		function _renderData(data) {
			$('#wjtId').val(data.body.questionnaireContent.questionnaireTemplateId);
			$('#status').val(data.body.questionnaireContent.status);
			$('#modifyTime').val(data.body.questionnaireContent.modifyTime);
			var jsonContentObj = JSON.parse(data.body.questionnaireContent.jsonContent);
			__renderBaseInfo(jsonContentObj.baseinfo);
			__renderZyxh(jsonContentObj.zyxh);
			__renderNyxh(jsonContentObj.nyxh);
			__renderFqpf(jsonContentObj.fqpf);
			__renderZysb(jsonContentObj.zysb);
		}

		function __renderBaseInfo(data) {
			$('#bi_qyName').val(data.bi_qyName);
			$('#bi_scLineName').val(data.bi_scLineName);
			$('#bi_scLineScale').val(data.bi_scLineScale);
			$('#bi_qyAddress').val(data.bi_qyAddress);
			$('#bi_linkman').val(data.bi_linkman);
			$('#bi_phoneNumber').val(data.bi_phoneNumber);
		}

		function __renderZyxh(data) {
	        for (var i = 1; i <= 6; i++) {
	        	$('#zyxh_sl_yclName_' + i).val(data.slTable[i - 1].zyxh_sl_yclName);
	        	$('#zyxh_sl_yclXhqk_' + i).val(data.slTable[i - 1].zyxh_sl_yclXhqk);
	        }
	        for (var i = 1; i <= 3; i++) {
	        	$('#zyxh_rl_yclName_' + i).val(data.rlTable[i - 1].zyxh_rl_yclName);
	        	$('#zyxh_rl_yclXhqk_' + i).val(data.rlTable[i - 1].zyxh_rl_yclXhqk);
	        }
	        $('#zyxh_slcl').val(data.zyxh_slcl);
	        for (var i = 1; i <= 10; i++) {
	        	$('#zyxh_sn_yclName_' + i).val(data.snTable[i - 1].zyxh_sn_yclName);
	        	$('#zyxh_sn_yclXhqk_' + i).val(data.snTable[i - 1].zyxh_sn_yclXhqk);
	        }
	        $('#zyxh_sncl').val(data.zyxh_sncl);
		}

		function __renderNyxh(data) {
			$('#nyxh_slfmdh').val(data.nyxh_slfmdh);
			$('#nyxh_kbslmh').val(data.nyxh_kbslmh);
			$('#nyxh_kbsldh').val(data.nyxh_kbsldh);
			$('#nyxh_kbslnh').val(data.nyxh_kbslnh);
			$('#nyxh_kbsndh').val(data.nyxh_kbsndh);
			$('#nyxh_kbsnnh').val(data.nyxh_kbsnnh);
			$('#nyxh_dwslfdl').val(data.nyxh_dwslfdl);
		}

		function __renderFqpf(data) {
			var title = ['yt', 'yw', 'snm', 'mm', 'bzj'];
			for (var i = 1; i <= 5; i++) {
				$('#fqpf_klw_npfl_' + title[i - 1]).val(data.klwTable[i - 1].fqpf_klw_npfl);
				$('#fqpf_klw_pfnd_' + title[i - 1]).val(data.klwTable[i - 1].fqpf_klw_pfnd);
				$('#fqpf_klw_ccfs_' + title[i - 1]).val(data.klwTable[i - 1].fqpf_klw_ccfs);
	    	}
	        title = ['so2', 'nox'];
	    	for (var i = 1; i <= 2; i++) {
	    		$('#fqpf_fq_npfl_' + title[i - 1]).val(data.fqTable[i - 1].fqpf_fq_npfl);
	    		$('#fqpf_fq_pfnd_' + title[i - 1]).val(data.fqTable[i - 1].fqpf_fq_pfnd);
	    		$('#fqpf_fq_ccfs_' + title[i - 1]).val(data.fqTable[i - 1].fqpf_fq_ccfs);
	    	}
	    	$('#fqpf_pd_sl').val(data.fqpf_pd_sl);
	    	$('#fqpf_pd_ccfs').val(data.fqpf_pd_ccfs);
	    	$("input:radio[name='fqpf_txgy'][value='" + data.fqpf_txgy + "']").attr('checked', 'checked');
		}

		function __renderZysb(data) {
			$('#zysb_slm_fmfs').val(data.zysb_slm_fmfs);
			$('#zysb_slm_ggxh').val(data.zysb_slm_ggxh);
			$('#zysb_slm_sl').val(data.zysb_slm_sl);
			$('#zysb_snm_fmfs').val(data.zysb_snm_fmfs);
			$('#zysb_snm_ggxh').val(data.zysb_snm_ggxh);
			$('#zysb_snm_sl').val(data.zysb_snm_sl);
			$('#zysb_y_gg').val(data.zysb_y_gg);
		}

	    // 保存数据
	    $('#commit').on('click', function() {
	    	var status = $('#status').val();
			var wjId = $('#wjId').val();
			var wjtId = $('#wjtId').val();
			var modifyTime = $('#modifyTime').val();
            var data = {
            	'id': wjId,
            	'questionnaireTemplateId': wjtId,
            	'status': status,
            	'modifyTime': modifyTime,
            	'jsonContent': getWJData()
            };
            $.ajax({
                url: '/online/wj/commit.html',
                method: 'PUT',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('提交成功');
                	} else {
                		alert('系统忙，请稍后重试');
                	}
                },
                error: function(data) {
                	alert('网络出现问题，请稍后重试');
                }
            });
		});

		$('#submit').on('click', function() {
			var status = $('#status').val();
			var wjId = $('#wjId').val();
            var wjtId = $('#wjtId').val();
            var modifyTime = $('#modifyTime').val();
            var data = {
            	'id': wjId,
            	'questionnaireTemplateId': wjtId,
            	'status': status,
            	'modifyTime': modifyTime,
            	'jsonContent': getWJData()
            };
            $.ajax({
                url: '/online/wj/saveTemp.html',
                method: 'POST',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('保存成功');
                	} else {
                		alert('系统忙，请稍后重试');
                	}
                },
                error: function(data) {
                	alert('网络出现问题，请稍后重试');
                }
            });
		});


	    function getWJData() {
			return JSON.stringify({
				'baseinfo': _getBaseInfoData(),
			    'zyxh': _getZyxhData(),
			    'nyxh': _getNyxhData(),
			    'fqpf': _getFqpfData(),
			    'zysb': _getZysbData()
			});
		}

		// module 1
		// 获取基本信息相关数据
		function _getBaseInfoData() {
			return {
				'bi_qyName': $('#bi_qyName').val(),
				'bi_scLineName': $('#bi_scLineName').val(),
				'bi_scLineScale': $('#bi_scLineScale').val(),
				'bi_qyAddress': $('#bi_qyAddress').val(),
				'bi_linkman': $('#bi_linkman').val(),
				'bi_phoneNumber': $('#bi_phoneNumber').val()
			}
		}

		// module 2
		// 获取资源消耗相关数据
		function _getZyxhData() {
			return {
				'slTable': __getSlTable(),
				'rlTable': __getRlTable(),
				'zyxh_slcl': $('#zyxh_slcl').val(),
				'snTable': __getSNTable(),
				'zyxh_sncl': $('#zyxh_sncl').val()
			}
		}

		// 获取熟料表格数据
		function __getSlTable() {
			var slTable = [];
			for (var i = 1; i <= 6; i++) {
				slTable.push({
					'zyxh_sl_yclName': $('#zyxh_sl_yclName_' + i).val(),
					'zyxh_sl_yclXhqk': $('#zyxh_sl_yclXhqk_' + i).val()
				});
			}
			return slTable;
		}

		// 获取燃料表格数据
		function __getRlTable() {
			var rlTable = [];
			for (var i = 1; i <= 3; i++) {
				rlTable.push({
					'zyxh_rl_yclName': $('#zyxh_rl_yclName_' + i).val(),
					'zyxh_rl_yclXhqk': $('#zyxh_rl_yclXhqk_' + i).val()
				});
			}
			return rlTable;
		}

	    // 获取水泥表格
	    function __getSNTable() {
	    	var snTable = [];
	    	for (var i = 1; i <= 10; i++) {
	    		snTable.push({
	    			'zyxh_sn_yclName': $('#zyxh_sn_yclName_' + i).val(),
	    			'zyxh_sn_yclXhqk': $('#zyxh_sn_yclXhqk_' + i).val()
	    		});
	    	}
	    	return snTable;
	    }

	    // module 3 
	    // 获取能源消耗数据
	    function _getNyxhData() {
	    	return {
	    		'nyxh_slfmdh': $('#nyxh_slfmdh').val(),
	    		'nyxh_kbslmh': $('#nyxh_kbslmh').val(),
	    		'nyxh_kbsldh': $('#nyxh_kbsldh').val(),
	    		'nyxh_kbslnh': $('#nyxh_kbslnh').val(),
	    		'nyxh_kbsndh': $('#nyxh_kbsndh').val(),
	    		'nyxh_kbsnnh': $('#nyxh_kbsnnh').val(),
	    		'nyxh_dwslfdl': $('#nyxh_dwslfdl').val()
	    	}
	    }

	    // module 4 获取废气排放数据
	    function _getFqpfData() {
	    	return {
	    		'klwTable': __getKlwTable(),
	    		'fqTable': __getFqTable(),
	    		'fqpf_pd_sl': $('#fqpf_pd_sl').val(),
	    		'fqpf_pd_ccfs': $('#fqpf_pd_ccfs').val(),
	    		'fqpf_txgy': $('input:radio[name=fqpf_txgy]:checked').val()
	    	}
	    }

	    function __getKlwTable() {
	    	var klwTable = [];
	    	var title = ['yt', 'yw', 'snm', 'mm', 'bzj'];
	    	for (var i = 1; i <= 5; i++) {
	    		klwTable.push({
	    			'pos': title[i - 1],
	    			'fqpf_klw_npfl': $('#fqpf_klw_npfl_' + title[i - 1]).val(),
	    			'fqpf_klw_pfnd': $('#fqpf_klw_pfnd_' + title[i - 1]).val(),
	    			'fqpf_klw_ccfs': $('#fqpf_klw_ccfs_' + title[i - 1]).val()
	    		});
	    	}
	    	return klwTable;
	    }

	    function __getFqTable() {
	    	var fqTable = [];
	    	var title = ['so2', 'nox'];
	    	for (var i = 1; i <= 2; i++) {
	    		fqTable.push({
	    			'pos': title[i - 1],
	    			'fqpf_fq_npfl': $('#fqpf_fq_npfl_' + title[i - 1]).val(),
	    			'fqpf_fq_pfnd': $('#fqpf_fq_pfnd_' + title[i - 1]).val(),
	    			'fqpf_fq_ccfs': $('#fqpf_fq_ccfs_' + title[i - 1]).val()
	    		});
	    	}
	    	return fqTable;
	    }

	    // module 5 获取主要设备数据
	    function _getZysbData() {
	    	return {
	    		'zysb_slm_fmfs': $('#zysb_slm_fmfs').val(),
	    		'zysb_slm_ggxh': $('#zysb_slm_ggxh').val(),
	    		'zysb_slm_sl': $('#zysb_slm_sl').val(),
	    		'zysb_snm_fmfs': $('#zysb_snm_fmfs').val(),
	    		'zysb_snm_ggxh': $('#zysb_snm_ggxh').val(),
	    		'zysb_snm_sl': $('#zysb_snm_sl').val(),
	    		'zysb_y_gg': $('#zysb_y_gg').val()
	    	}
	    }

	});

})(jQuery);