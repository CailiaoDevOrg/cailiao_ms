(function($) {

	$(function() {

		// 加载数据
		loadData();

		function loadData() {
			var wjId = $('#wjId').val();
            $.ajax({
	            url: 'online/wj/detail/' + wjId + '.html',
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
            if (getWJData(true)) {
            	var data = {
                    	'id': wjId,
                    	'questionnaireTemplateId': wjtId,
                    	'status': status,
                    	'modifyTime': modifyTime,
                    	'jsonContent': getWJData(true)
                    };
            	 $.ajax({
                     url: 'online/wj/commit.html',
                     method: 'PUT',
                     data: JSON.stringify(data),
                     contentType: 'application/json',
                     success: function(data) {
                     	data = JSON.parse(data);
                     	if (data.retCode == 200) {
                             alert('提交成功');
                             window.location.href = 'online/wj/history/' + wjtId + '.html';
                     	} else {
                     		alert('系统忙，请稍后重试');
                     	}
                     },
                     error: function(data) {
                     	alert('网络出现问题，请稍后重试');
                     }
                 });
            }          
           
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
                    	'jsonContent': getWJData(false)
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
                            window.location.href = 'online/wj/history/' + wjtId + '.html';
                    	} else {
                    		alert('系统忙，请稍后重试');
                    	}
                    },
                    error: function(data) {
                    	alert('网络出现问题，请稍后重试');
                    }
                });           
            
		});


	   function getWJData(flag) {
			if (flag) {
				if (!_getBaseInfoData(flag) || !_getZyxhData(flag) || !_getNyxhData(flag) || !_getFqpfData(flag) || !_getZysbData(flag) ) {
					return false;
				} else {
					return JSON.stringify({
						'baseinfo': _getBaseInfoData(flag),
					    'zyxh': _getZyxhData(flag),
					    'nyxh': _getNyxhData(flag),
					    'fqpf': _getFqpfData(flag),
					    'zysb': _getZysbData(flag)
					});
				}
			} else {
				return JSON.stringify({
					'baseinfo': _getBaseInfoData(flag),
				    'zyxh': _getZyxhData(flag),
				    'nyxh': _getNyxhData(flag),
				    'fqpf': _getFqpfData(flag),
				    'zysb': _getZysbData(flag)
				});
			
			}
		
			
		}

		// module 1
		// 获取基本信息相关数据
		function _getBaseInfoData(flag) {
			var qyName = $('#bi_qyName').val();
			var scLineName = $('#bi_scLineName').val();
			var scLineScale = $('#bi_scLineScale').val();
			var qyAddress = $('#bi_qyAddress').val();
			var linkman = $('#bi_linkman').val();
			var phoneNumber = $('#bi_phoneNumber').val();
			if (flag) {
				if (qyName.trim()=='') {
					alert("企业名不能为空");
					return false;
				} 
				if (scLineName.trim()=='') {
					alert("生产线名称不能为空");
					return false;
				} 
				if(scLineScale.trim()=='') {
					alert("生产线规模不能为空");
					return false;
				} 
				if (scLineScale < 0) {
					alert('生产线规模不能小于0');
					return false;
				}
				if (scLineScale > 20000) {
					alert('生产线规模不能大于20000');
					return false;
				}
				if (qyAddress.trim()=='') {
					alert("企业地址不能为空");
					return false;
				} 
				if (phoneNumber != '') {					
					 var isMob = /^(13[0-9]{9})|(15[89][0-9]{8})$/;
					 if(isMob.test(phoneNumber)){											
					     return true;
					    } else {
					    	 alert("请输入格式正确的手机号码！");
					    	 return false;
					    }
				} else {
					return {
						'bi_qyName': qyName,
						'bi_scLineName': scLineName,
						'bi_scLineScale': scLineScale,
						'bi_qyAddress': qyAddress,
						'bi_linkman': linkman,
						'bi_phoneNumber': phoneNumber
					}
				}
				
			}
			return {
				'bi_qyName': qyName,
				'bi_scLineName': scLineName,
				'bi_scLineScale': scLineScale,
				'bi_qyAddress': qyAddress,
				'bi_linkman': linkman,
				'bi_phoneNumber': phoneNumber
			}
		}

		// module 2
		// 获取资源消耗相关数据
		function _getZyxhData(flag) {
			if (!__getSlTable(flag) || !__getRlTable(flag) || !__getSNTable(flag)) {
				return false;
			} else {
				return {
					'slTable': __getSlTable(flag),
					'rlTable': __getRlTable(flag),
					'zyxh_slcl': $('#zyxh_slcl').val(),
					'snTable': __getSNTable(flag),
					'zyxh_sncl': $('#zyxh_sncl').val()
				}
			}
			
		}

		// 获取熟料表格数据
		function __getSlTable(flag) {
			var slTable = [];
			slTable.push({
				'zyxh_sl_yclName':-99999,
				'zyxh_sl_yclXhqk':-99999
			});
			for (var i = 1; i <= 6; i++) {
				if (flag) {
					if ($('#zyxh_sl_yclName_' + i).val() != ''
							&& $('#zyxh_sl_yclXhqk_' + i).val() == ''
							|| $('#zyxh_sl_yclName_' + i).val() == ''
							&& $('#zyxh_sl_yclXhqk_' + i).val() != '') {
						alert("熟料烧成原材料名称和消耗情况必须保持一致！");
						//break;
						return false;
					} else {
						slTable.push({
							'zyxh_sl_yclName': $('#zyxh_sl_yclName_' + i).val(),
							'zyxh_sl_yclXhqk': $('#zyxh_sl_yclXhqk_' + i).val()
						});
					}
				} else {
					slTable.push({
						'zyxh_sl_yclName': $('#zyxh_sl_yclName_' + i).val(),
						'zyxh_sl_yclXhqk': $('#zyxh_sl_yclXhqk_' + i).val()
					});
				}
				
			}
			return slTable;
		}

		// 获取燃料表格数据
		function __getRlTable(flag) {
			var rlTable = [];
			rlTable.push({
				'zyxh_rl_yclName':-99999,
				'zyxh_rl_yclXhqk':-99999
			});
			for (var i = 1; i <= 3; i++) {
				if (flag) {
					if ($('#zyxh_rl_yclName_' + i).val() == ''
						&& $('#zyxh_rl_yclXhqk_' + i).val() != ''
							|| $('#zyxh_rl_yclName_' + i).val() != ''
								&& $('#zyxh_rl_yclXhqk_' + i).val() == '') {
						alert("燃料的原材料名称和消耗情况必须一致！");
						return false;
					} else {
						rlTable.push({
							'zyxh_rl_yclName': $('#zyxh_rl_yclName_' + i).val(),
							'zyxh_rl_yclXhqk': $('#zyxh_rl_yclXhqk_' + i).val()
						});
					}
				}
				rlTable.push({
					'zyxh_rl_yclName': $('#zyxh_rl_yclName_' + i).val(),
					'zyxh_rl_yclXhqk': $('#zyxh_rl_yclXhqk_' + i).val()
				});
			}
			return rlTable;
		}

	    // 获取水泥表格
	    function __getSNTable(flag) {
	    	var snTable = [];
	    	snTable.push({
	    		'zyxh_sn_yclName': -99999,
    			'zyxh_sn_yclXhqk': -99999
	    	});
	    	for (var i = 1; i <= 10; i++) {
	    		if (flag) {
	    			if ($('#zyxh_sn_yclName_' + i).val() == ''
	    				&& $('#zyxh_sn_yclXhqk_' + i).val() != ''
	    					|| $('#zyxh_sn_yclName_' + i).val() != ''
	    						&& $('#zyxh_sn_yclXhqk_' + i).val() == '') {
	    				alert("水泥制成用原材料的名称和消耗情况必须一致！");
	    				return false;
	    			}
	    		}
	    		snTable.push({
	    			'zyxh_sn_yclName': $('#zyxh_sn_yclName_' + i).val(),
	    			'zyxh_sn_yclXhqk': $('#zyxh_sn_yclXhqk_' + i).val()
	    		});
	    	}
	    	return snTable;
	    }

	    // module 3 
	    // 获取能源消耗数据
	    function _getNyxhData(flag) {
	    	if (flag) {
	    		if ($('#nyxh_slfmdh').val().trim()=='') {
	    			alert("生料粉末工段电耗不能为空");
	    			return false;
	    		} else if ($('#nyxh_kbslmh').val().trim() == '') {
	    			alert("可比熟料综合煤耗不能为空");
	    			return false;
	    		} else if ($('#nyxh_kbsldh').val().trim() == '') {
	    			alert("可比熟料综合电耗不能为空");
	    			return false;
	    		} else if ($('#nyxh_kbslnh').val().trim() == '') {
	    			alert("可比熟料综合能耗不能为空");
	    			return false;
	    		} else if ($('#nyxh_kbsndh').val().trim() == '') {
	    			alert('可比水泥综合电耗不能为空');
	    			return false;
	    		} else if ($('#nyxh_kbsnnh').val().trim() == '') {
	    			alert('可比水泥综合能耗不能为空');
	    			return false;
	    		} else if ($('#nyxh_dwslfdl').val().trim() == '') {
	    			alert('单位熟料余热发电量不能为空');
	    			return false;
	    		} else {
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
	    	}
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
	    function _getFqpfData(flag) {
	    	if (!__getKlwTable(flag) || !__getFqTable(flag)) {
	    		return false;
	    	}
	    	return {
	    		'klwTable': __getKlwTable(flag),
	    		'fqTable': __getFqTable(flag),
	    		'fqpf_pd_sl': $('#fqpf_pd_sl').val(),
	    		'fqpf_pd_ccfs': $('#fqpf_pd_ccfs').val(),
	    		'fqpf_txgy': $('input:radio[name=fqpf_txgy]:checked').val()
	    	}
	    }

	    function __getKlwTable(flag) {
	    	var klwTable = [];
	    	var title = ['yt', 'yw', 'snm', 'mm', 'bzj'];
	    	for (var i = 1; i <= 5; i++) {
	    		if (flag) {
	    			if (i == 1) {
	    				if ($('#fqpf_klw_npfl_' + title[i - 1]).val().trim() == '' || $('#fqpf_klw_pfnd_' + title[i - 1]).val() == '') {
							alert('窑头数据不能为空');
							return false;
						} else {
							klwTable.push({
		    	    			'pos': title[i - 1],
		    	    			'fqpf_klw_npfl': $('#fqpf_klw_npfl_' + title[i - 1]).val(),
		    	    			'fqpf_klw_pfnd': $('#fqpf_klw_pfnd_' + title[i - 1]).val()
//		    	    			'fqpf_klw_ccfs': $('#fqpf_klw_ccfs_' + title[i - 1]).val()
		    	    		});
						}
	    				
	    			} else if (i == 2) {
	    				if ($('#fqpf_klw_npfl_' + title[i - 1]).val().trim() == '' || $('#fqpf_klw_pfnd_' + title[i - 1]).val() == '') {
	    					alert('窑尾数据不能为空');
							return false;
	    				} else {
	    					klwTable.push({
		    	    			'pos': title[i - 1],
		    	    			'fqpf_klw_npfl': $('#fqpf_klw_npfl_' + title[i - 1]).val(),
		    	    			'fqpf_klw_pfnd': $('#fqpf_klw_pfnd_' + title[i - 1]).val()
//		    	    			'fqpf_klw_ccfs': $('#fqpf_klw_ccfs_' + title[i - 1]).val()
		    	    		});
	    				}
	    			} else {
	    				klwTable.push({
	    	    			'pos': title[i - 1],
	    	    			'fqpf_klw_npfl': $('#fqpf_klw_npfl_' + title[i - 1]).val(),
	    	    			'fqpf_klw_pfnd': $('#fqpf_klw_pfnd_' + title[i - 1]).val()
//	    	    			'fqpf_klw_ccfs': $('#fqpf_klw_ccfs_' + title[i - 1]).val()
	    	    		});
	    			}
	    		} else {
	    			klwTable.push({
		    			'pos': title[i - 1],
		    			'fqpf_klw_npfl': $('#fqpf_klw_npfl_' + title[i - 1]).val(),
		    			'fqpf_klw_pfnd': $('#fqpf_klw_pfnd_' + title[i - 1]).val()
//		    			'fqpf_klw_ccfs': $('#fqpf_klw_ccfs_' + title[i - 1]).val()
		    		});
	    		}
	    		
	    	}
	    	return klwTable;
	    }

	    function __getFqTable(flag) {
	    	var fqTable = [];
	    	var title = ['so2', 'nox'];
	    	for (var i = 1; i <= 2; i++) {
	    		if (flag) {
	    			if (i == 1) {
	    				if ($('#fqpf_fq_npfl_' + title[i - 1]).val().trim() == '') {
		    				alert('年排放量的SO2不能为空');
		    				return false;
		    			} else if ($('#fqpf_fq_pfnd_' + title[i - 1]).val().trim() == '') {
		    				alert('排放浓度的SO2不能为空');
		    				return false;
		    			} else {
		    				fqTable.push({
		    	    			'pos': title[i - 1],
		    	    			'fqpf_fq_npfl': $('#fqpf_fq_npfl_' + title[i - 1]).val(),
		    	    			'fqpf_fq_pfnd': $('#fqpf_fq_pfnd_' + title[i - 1]).val()
//		    	    			'fqpf_fq_ccfs': $('#fqpf_fq_ccfs_' + title[i - 1]).val()
		    	    		});
		    			}
	    			} else if (i == 2) {
	    				if ($('#fqpf_fq_npfl_' + title[i - 1]).val().trim() == '') {
		    				alert('年排放量的NO2不能为空');
		    				return false;
		    			} else if ($('#fqpf_fq_pfnd_' + title[i - 1]).val().trim() == '') {
		    				alert('排放浓度的NO2不能为空');
		    				return false;
		    			} else {
		    				fqTable.push({
		    	    			'pos': title[i - 1],
		    	    			'fqpf_fq_npfl': $('#fqpf_fq_npfl_' + title[i - 1]).val(),
		    	    			'fqpf_fq_pfnd': $('#fqpf_fq_pfnd_' + title[i - 1]).val()
//		    	    			'fqpf_fq_ccfs': $('#fqpf_fq_ccfs_' + title[i - 1]).val()
		    	    		});
		    			}
	    			}
	    			
	    		}
	    		fqTable.push({
	    			'pos': title[i - 1],
	    			'fqpf_fq_npfl': $('#fqpf_fq_npfl_' + title[i - 1]).val(),
	    			'fqpf_fq_pfnd': $('#fqpf_fq_pfnd_' + title[i - 1]).val()
//	    			'fqpf_fq_ccfs': $('#fqpf_fq_ccfs_' + title[i - 1]).val()
	    		});
	    	}
	    	return fqTable;
	    }

	    // module 5 获取主要设备数据
	    function _getZysbData(flag) {
	    	var zysb_slm_fmfs = $('#zysb_slm_fmfs').val();
	    	var zysb_slm_ggxh = $('#zysb_slm_ggxh').val();
	    	var zysb_slm_sl = $('#zysb_slm_sl').val();
	    	var zysb_snm_fmfs = $('#zysb_snm_fmfs').val();
	    	var zysb_snm_ggxh = $('#zysb_snm_ggxh').val();
	    	var zysb_snm_sl = $('#zysb_snm_sl').val();
	    	var zysb_y_gg = $('#zysb_y_gg').val();
	    	if (flag) {
	    		if (zysb_slm_fmfs == '') {
	    			alert('生料磨方式不能为空');
	    			return false;
	    		} 
	    		if (zysb_slm_ggxh == '') {
	    			alert('生料磨规格型号不能为空');
	    			return false;
	    		} 
	    		if (zysb_slm_sl == '') {
	    			alert('生料磨数量不能为空');
	    		} 
	    		if (zysb_snm_fmfs == '') {
	    			alert('水泥磨粉磨方式不能为空');
	    			return false;
	    		}
	    		if (zysb_snm_ggxh == '') {
	    			alert('水泥磨规格型号不能为空');
	    			return false;
	    		}
	    		if (zysb_snm_sl == '') {
	    			alert('水泥磨的数量不能为空');
	    			return false;
	    		}
	    		if (zysb_y_gg == '') {
	    			alert('窑规格不能为空');
	    			return false;
	    		}
	    		return {
		    		'zysb_slm_fmfs': zysb_slm_fmfs,
		    		'zysb_slm_ggxh': zysb_slm_ggxh,
		    		'zysb_slm_sl': zysb_slm_sl,
		    		'zysb_snm_fmfs': zysb_snm_fmfs,
		    		'zysb_snm_ggxh': zysb_snm_ggxh,
		    		'zysb_snm_sl': zysb_snm_sl,
		    		'zysb_y_gg': zysb_y_gg
		    	}
	    	}
	    	return {
	    		'zysb_slm_fmfs': zysb_slm_fmfs,
	    		'zysb_slm_ggxh': zysb_slm_ggxh,
	    		'zysb_slm_sl': zysb_slm_sl,
	    		'zysb_snm_fmfs': zysb_snm_fmfs,
	    		'zysb_snm_ggxh': zysb_snm_ggxh,
	    		'zysb_snm_sl': zysb_snm_sl,
	    		'zysb_y_gg': zysb_y_gg
	    	}
	    }




	});

})(jQuery);