(function($) {

	$(function() {

		$('#showHistoryList').on('click', function() {
			var wjtId = $('#wjtId').val();
			window.location.href = 'online/wj/history/' + wjtId + '.html';
		});

		$('#commit').on('click', function() {
			var wjtId = $('#wjtId').val();
            var data = {
            	'questionnaireTemplateId': wjtId,
            	'jsonContent': JSON.stringify(getWJData())
            };
            $.ajax({
                url: 'online/wj/commit.html',
                method: 'PUT',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        debugger;
                        alert('提交成功');
                        window.opener = null;
                        window.close();
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
            var wjtId = $('#wjtId').val();
            var data = {
            	'questionnaireTemplateId': wjtId,
            	'jsonContent': JSON.stringify(getWJData())
            };
            $.ajax({
                url: 'online/wj/saveTemp.html',
                method: 'POST',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('保存成功');
                        window.opener = null;
                        window.close();
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
			return {
				'baseinfo': _getBaseInfoData(),
			    'zyxh': _getZyxhData(),
			    'nyxh': _getNyxhData(),
			    'fqpf': _getFqpfData(),
			    'zysb': _getZysbData()
			}
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