(function($) {

	$(function() {

		// alert($('#wjId').val());
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

	});

})(jQuery);