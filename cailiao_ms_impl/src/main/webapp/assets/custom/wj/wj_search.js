(function($){
    
    $(function() {

        $('#search').on('click', function() {
            var searchConditionList = [];
            $('input[name=searchCondition]:checked').each(function() {
                searchConditionList.push($(this).val());
            });
            if (searchConditionList.length == 0) {
                alert('请选择查询条件');
                return;
            }
            var data = {};
            for (var i = 0, len = searchConditionList.length; i < len; i++) {
                switch (searchConditionList[i]) {
                    case 'jbxx' : {
                        fillJbxxData(data);
                        break;
                    }
                    case 'zyxh': {
                        fillZyxhData(data);
                        break;
                    }
                    case 'nyxh': {
                        fillNyxhData(data);
                        break;
                    }
                    case 'fqpf': {
                        fillFqpfData(data);
                        break;
                    }
                    case 'zysb': {
                        fillZysbData(data);
                        break;
                    }
                    default: {
                        alert('非法的查询条件');
                    }
                }
            }
            if ($.isEmptyObject(data)) {
                alert('请输入查询条件');
            } else {
            	data.questionnaireTemplateId = $('#wjtId').val();
                $.ajax({
                    url: 'wj/doSearch.html',
                    method: 'POST',
                    data: JSON.stringify(data),
                    contentType: 'application/json',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            if (data.body == undefined || data.body.resultList == undefined) {
                                alert('没有满足条件的数据');
                            } else {
                                alert(data.body.resultList);
                            }
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
        
        function fillJbxxData(data) {
            if ($('#bi_qyName').val() != '') {
                data.bi_qyName = $('#bi_qyName').val();
            }
            if ($('#bi_scLineName').val() != '') {
                data.bi_scLineName = $('#bi_scLineName').val();
            }
            if ($('#bi_scLineScale').val() != '') {
                data.bi_scLineScale = $('#bi_scLineScale').val();
            }
            if ($('#bi_qyAddress').val() != '') {
                data.bi_qyAddress = $('#bi_qyAddress').val();
            }
            if ($('#bi_linkman').val() != '') {
                data.bi_linkman = $('#bi_linkman').val();
            }
            if ($('#bi_phoneNumber').val() != '') {
                data.bi_phoneNumber = $('#bi_phoneNumber').val();
            }
        }

        function fillZyxhData(data) {
            if ($('#zyxh_slcl').val() != '') {
                data.zyxh_slcl = $('#zyxh_slcl').val();
            }
            if ($('#zyxh_sncl').val() != '') {
                data.zyxh_sncl = $('#zyxh_sncl').val();
            }
        }

        function fillNyxhData(data) {
            if ($('#nyxh_slfmdh').val() != '') {
                data.nyxh_slfmdh = $('#nyxh_slfmdh').val();
            }
            if ($('#nyxh_kbslmh').val() != '') {
                data.nyxh_kbslmh = $('#nyxh_kbslmh').val();
            }
            if ($('#nyxh_kbsldh').val() != '') {
                data.nyxh_kbsldh = $('#nyxh_kbsldh').val();
            }
            if ($('#nyxh_kbslnh').val() != '') {
                data.nyxh_kbslnh = $('#nyxh_kbslnh').val();
            }
            if ($('#nyxh_kbsndh').val() != '') {
                data.nyxh_kbsndh = $('#nyxh_kbsndh').val();
            }
            if ($('#nyxh_kbsnnh').val() != '') {
                data.nyxh_kbsnnh = $('#nyxh_kbsnnh').val();
            }
            if ($('#nyxh_dwslfdl').val() != '') {
                data.nyxh_dwslfdl = $('#nyxh_dwslfdl').val();
            }
        }

        function fillFqpfData(data) {
            if ($('#fqpf_pd_sl').val() != '') {
                data.fqpf_pd_sl = $('#fqpf_pd_sl').val();
            }
            if ($('#fqpf_pd_ccfs').val() != '') {
                data.fqpf_pd_ccfs = $('#fqpf_pd_ccfs').val();
            }
            if ($('input:radio[name=fqpf_txgy]:checked').val() != '') {
                data.fqpf_txgy = $('input:radio[name=fqpf_txgy]:checked').val();
            }
        }

        function fillZysbData(data) {
            if ($('#zysb_slm_fmfs').val() != '') {
                data.zysb_slm_fmfs = $('#zysb_slm_fmfs').val();
            }
            if ($('#zysb_slm_ggxh').val() != '') {
                data.zysb_slm_ggxh = $('#zysb_slm_ggxh').val();
            }
            if ($('#zysb_slm_sl').val() != '') {
                data.zysb_slm_sl = $('#zysb_slm_sl').val();
            }
            if ($('#zysb_snm_fmfs').val() != '') {
                data.zysb_snm_fmfs = $('#zysb_snm_fmfs').val();
            }
            if ($('#zysb_snm_ggxh').val() != '') {
                data.zysb_snm_ggxh = $('#zysb_snm_ggxh').val();
            }
            if ($('#zysb_snm_sl').val() != '') {
                data.zysb_snm_sl = $('#zysb_snm_sl').val();
            }
            if ($('#zysb_y_gg').val() != '') {
                data.zysb_y_gg = $('#zysb_y_gg').val();
            }
        }

    	// 基本信息
    	$('#jbxxCb').on('click', function() {
    		if ($(this).is(':checked')) {
    			drawJbxxSearchCondition();
    		} else {
    			removeJbxxSearchCondition();
    		}
    	});

    	function drawJbxxSearchCondition() {
    		$div = '<div class="col-md-6" id="jbxx">\
                        <div class="box box-primary">\
        		            <div class="box-header with-border">\
        		                <h3 class="box-title">基本信息</h3>\
        		            </div>\
        		            <div class="box-body">\
                                <div class="row">\
                                    <div class="col-md-6">\
                                        <div class="form-group">\
                                            <label for="bi_qyName">企业名称</label>\
                                            <input type="text" class="form-control" id="bi_qyName" placeholder="请输入企业名称">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="bi_scLineName">生产线名称</label>\
                                            <input type="text" class="form-control" id="bi_scLineName" placeholder="请输入生产线名称">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="bi_scLineScale">生产线设计规模</label>\
                                            <input type="text" class="form-control" id="bi_scLineScale" placeholder="请输入生产线设计规模">\
                                        </div>\
                                    </div>\
                                    <div class="col-md-6">\
                                        <div class="form-group">\
                                            <label for="bi_qyAddress">企业所在地址</label>\
                                            <input type="text" class="form-control" id="bi_qyAddress" placeholder="请输入企业所在地址">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="bi_linkman">填表联系人</label>\
                                            <input type="text" class="form-control" id="bi_linkman" placeholder="请输入填表联系人">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="bi_phoneNumber">联系电话</label>\
                                            <input type="text" class="form-control" id="bi_phoneNumber" placeholder="请输入联系电话">\
                                        </div>\
                                    </div>\
                                </div>\
        		            </div>\
        		        </div>\
                    </div>';
    		$container = $('.searchCondition');
    		$container.prepend($div);
    	}

    	function removeJbxxSearchCondition() {
    		$('#jbxx').remove();
    	}

    	// 资源消耗
    	$('#zyxhCb').on('click', function() {
    		if ($(this).is(':checked')) {
    			drawZyxhSearchCondition();
    		} else {
    			removeZyxhSearchCondition();
    		}
    	});

    	function drawZyxhSearchCondition() {
    		$div = '<div class="col-md-6" id="zyxh">\
                        <div class="box box-primary">\
        		            <div class="box-header with-border">\
        		                <h3 class="box-title">资源消耗</h3>\
        		            </div>\
        		            <div class="box-body">\
                                <div class="form-group">\
                                    <label for="zyxh_slcl">熟料产量:万吨/年</label>\
                                    <input type="text" class="form-control" id="zyxh_slcl" placeholder="熟料产量:万吨/年">\
                                </div>\
                                <div class="form-group">\
                                    <label for="zyxh_sncl">水泥产量(万吨/年)</label>\
                                    <input type="text" class="form-control" id="zyxh_sncl" placeholder="水泥产量:万吨/年">\
                                </div>\
        		            </div>\
        		        </div>\
                    </div>';
    		$container = $('.searchCondition');
    		if ($container.find('#jbxx').length > 0) {
    			$('#jbxx').after($div);
    		} else {
    			$container.prepend($div);
    		}
    	}

    	function removeZyxhSearchCondition() {
    		$('#zyxh').remove();
    	}

    	// 能源消耗
    	$('#nyxhCb').on('click', function() {
    		if ($(this).is(':checked')) {
    			drawNyxhSearchCondition();
    		} else {
    			removeNyxhSearchCondition();
    		}
    	});

    	function drawNyxhSearchCondition() {
    		$div = '<div class="col-md-6" id="nyxh">\
                        <div class="box box-primary">\
        		            <div class="box-header with-border">\
        		                <h3 class="box-title">能源消耗</h3>\
        		            </div>\
        		            <div class="box-body">\
                                <div class="row">\
                                    <div class="col-md-6">\
                                        <div class="form-group">\
                                            <label for="nyxh_slfmdh">生料粉末工段电耗</label>\
                                            <input type="text" class="form-control" id="nyxh_slfmdh" placeholder="单位：kWh/t">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="nyxh_kbslmh">可比孰料综合煤耗</label>\
                                            <input type="text" class="form-control" id="nyxh_kbslmh" placeholder="单位：kgce/t">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="nyxh_kbsldh">可比孰料综合电耗</label>\
                                            <input type="text" class="form-control" id="nyxh_kbsldh" placeholder="单位：kWh/t">\
                                        </div>\
                                    </div>\
                                    <div class="col-md-6">\
                                        <div class="form-group">\
                                            <label for="nyxh_kbslnh">可比孰料综合能耗</label>\
                                            <input type="text" class="form-control" id="nyxh_kbslnh" placeholder="单位：kgce/t">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="nyxh_kbsndh">可比水泥综合电耗</label>\
                                            <input type="text" class="form-control" id="nyxh_kbsndh" placeholder="单位：kWh/t">\
                                        </div>\
                                        <div class="form-group">\
                                            <label for="nyxh_kbsnnh">可比水泥综合能耗</label>\
                                            <input type="text" class="form-control" id="nyxh_kbsnnh" placeholder="单位：kgce/t">\
                                        </div>\
                                    </div>\
                                    <div class="col-md-6">\
                                        <div class="form-group">\
                                            <label for="nyxh_dwslfdl">单位熟料余发热电量</label>\
                                            <input type="text" class="form-control" id="nyxh_dwslfdl" placeholder="单位：kWh/t">\
                                        </div>\
                                    </div>\
                                </div>\
        		            </div>\
        		        </div>\
                    </div>';
    		$container = $('.searchCondition');
    		if ($container.find('#zyxh').length > 0) {
    			$('#zyxh').after($div);
    		} else if ($container.find('#jbxx').length > 0) {
    			$('#jbxx').after($div);
    		} else {
    			$container.prepend($div);
    		}
    	}

    	function removeNyxhSearchCondition() {
    		$('#nyxh').remove();
    	}

    	// 废气排放
        $('#fqpfCb').on('click', function() {
    		if ($(this).is(':checked')) {
    			drawFqpfSearchCondition();
    		} else {
    			removeFqpfSearchCondition();
    		}
    	});

    	function drawFqpfSearchCondition() {
    		$div = '<div class="col-md-6" id="fqpf">\
                        <div class="box box-primary">\
        		            <div class="box-header with-border">\
        		                <h3 class="box-title">废气排放</h3>\
        		            </div>\
        		            <div class="box-body">\
                                <div class="form-group">\
                                    <label for="fqpf_pd_sl">喷氮 kg/t熟料</label>\
                                    <input type="text" class="form-control" id="fqpf_pd_sl" placeholder="喷氮 kg/t熟料">\
                                </div>\
                                <div class="form-group">\
                                    <label for="fqpf_pd_ccfs">喷氮 除尘方式(电/袋)</label>\
                                    <input type="text" class="form-control" id="fqpf_pd_ccfs" placeholder="喷氮 除尘方式(电/袋)">\
                                </div>\
                                <div class="form-group">\
                                    1 <input type="radio" name="fqpf_txgy" value="SNCR"> SNCR <br />\
                                    2 <input type="radio" name="fqpf_txgy" value="分级燃烧"> 分级燃烧 <br />\
                                    3 <input type="radio" name="fqpf_txgy" value="SNCR 分级燃烧"> 1+2 <br />\
                                    4 <input type="radio" name="fqpf_txgy" value="其他"> 其他 <br />\
                                </div>\
        		            </div>\
        		        </div>\
                    </div>';
    		$container = $('.searchCondition');
    		if ($container.find('#zysb').length > 0) {
    			$('#zysb').before($div);
    		} else {
    			$container.append($div);
    		}
    	}

    	function removeFqpfSearchCondition() {
    		$('#fqpf').remove();
    	}
        
        // 主要设备
        $('#zysbCb').on('click', function() {
    		if ($(this).is(':checked')) {
    			drawZysbSearchCondition();
    		} else {
    			removeZysbSearchCondition();
    		}
    	});

    	function drawZysbSearchCondition() {
    		$div = '<div class="col-md-6" id="zysb">\
                        <div class="box box-primary">\
        		            <div class="box-header with-border">\
        		                <h3 class="box-title">主要设备</h3>\
        		            </div>\
        		            <div class="box-body">\
                                <div class="row">\
                                    <div class="col-md-6">\
                                        <div class="box box-default">\
                                            <div class="box-header">生料磨</div>\
                                            <div class="box-body">\
                                                <div class="form-group">\
                                                    <label for="zysb_slm_fmfs">生料磨粉磨方式</label>\
                                                    <input type="text" class="form-control" id="zysb_slm_fmfs" placeholder="生料磨粉磨方式">\
                                                </div>\
                                                <div class="form-group">\
                                                    <label for="zysb_slm_ggxh">生料磨规格型号</label>\
                                                    <input type="text" class="form-control" id="zysb_slm_ggxh" placeholder="生料磨规格型号">\
                                                </div>\
                                                <div class="form-group">\
                                                    <label for="zysb_slm_sl">生料磨数量</label>\
                                                    <input type="text" class="form-control" id="zysb_slm_sl" placeholder="生料磨数量">\
                                                </div>\
                                            </div>\
                                        </div>\
                                    </div>\
                                    <div class="col-md-6">\
                                        <div class="box box-default">\
                                            <div class="box-header">水泥磨</div>\
                                            <div class="box-body">\
                                                <div class="form-group">\
                                                    <label for="zysb_snm_fmfs">粉磨方式</label>\
                                                    <input type="text" class="form-control" id="zysb_snm_fmfs" placeholder="生料磨粉磨方式">\
                                                </div>\
                                                <div class="form-group">\
                                                    <label for="zysb_snm_ggxh">规格型号</label>\
                                                    <input type="text" class="form-control" id="zysb_snm_ggxh" placeholder="生料磨规格型号">\
                                                </div>\
                                                <div class="form-group">\
                                                    <label for="zysb_snm_sl">数量</label>\
                                                    <input type="text" class="form-control" id="zysb_snm_sl" placeholder="生料磨数量">\
                                                </div>\
                                            </div>\
                                        </div>\
                                    </div>\
                                    <div class="col-md-6">\
                                        <div class="box box-default">\
                                            <div class="box-header">窑</div>\
                                            <div class="box-body">\
                                                <div class="form-group">\
                                                    <label for="zysb_y_gg">规格</label>\
                                                    <input type="text" class="form-control" id="zysb_y_gg" placeholder="生料磨规格型号">\
                                                </div>\
                                            </div>\
                                        </div>\
                                    </div>\
                                </div>\
        		            </div>\
        		        </div>\
                    </div>';
    		$container = $('.searchCondition');
    		$container.append($div);
    	}

    	function removeZysbSearchCondition() {
    		$('#zysb').remove();
    	}
    });
})(jQuery);