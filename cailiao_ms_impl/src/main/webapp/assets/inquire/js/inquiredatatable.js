/**
 * Created by coder on 2015/9/8.
 */


function get_analyse_view_template()
{
    return {
        //height: getHeight(),
        columns: [
            [
                {
                    title: 'Analyse ID',
                    field: 'id',
                    visible: false
                },
                {
                    title:'Analyse Name',
                    field:'name',
                    formatter:analyseFormatter
                },
                {
                    title:'Create Time',
                    field:'create_time'
                },
                {
                    title: 'Type',
                    field: 'type',
                    formatter: typeFormatter
                },
                {
                    title: 'Description',
                    field: 'description'
                },
                {
                    title: 'samples count',
                    field: 'sample_count'
                },
                {
                    title: 'Analysis',
                    field: 'anno_status',
                    events: annoEvents,
                    formatter: annoFormatter
                },
                /*{
                    title: 'Detail Analyse',
                    field: 'detail',
                    events: detailEvents,
                    formatter: detailFormatter
                },*/
                {
                    title:'Operation',
                    field:'operation',
                    events: operateEvents,
                    formatter: operateFormatter
                }

            ]

        ]
    };
}

$(document).ready(function(){
    navbarActiveChange('analyses');
    var analyse_view = new MGeneralTableTool.MGeneralTable();
    analyse_view.CreateTable('table',get_analyse_view_template(),"./index.php?r=analyses/load-analyses",{},true);

    $table = analyse_view.getTable();
});


////////////////////////////////////////////////////////////////////////////////////////////////////
window.detailEvents = {
    'click .detail': function (e,value,row,index) {
        window.location = "./index.php?r=analyses/home&id=" + row.id;
    }
};

window.operateEvents = {
    'click .remove': function (e, value, row, index) {

        $.messager.model = {
            ok:{ text: "OK", classed: 'btn btn-primary' },
            cancel: { text: "Cancel", classed: 'btn btn-default' }
        };
        $.messager.confirm("Delete", "Are you sure you want to delete this group?", function() {
            var csrf = getCsrf();
            $.post("./index.php?r=analyses/delete",{_csrf:csrf,id:row.id},function(data,status){
                var obj = JSON.parse(data);
                if(obj.delete)
                {
                    $table.bootstrapTable('remove', {
                        field: 'id',
                        values: [row.id]
                    });
                }
                else
                {
                    alert('Delete Analyse failed');
                }
            }).fail(function(){
                alert('Delete Analyse failed');
            });
        });
    }
};

function analyseFormatter(value, row, index){
    return [
        '<span class="fa fa-area-chart" style="color:#444"></span>&nbsp;&nbsp;' + value ].join('');
}

function detailFormatter(value, row, index) {

    if(row.anno_status == 2)
    {
        return ['<button class="detail btn btn-xs btn-success" data-pjax="0" aria-label="Detail" title="Detail" style="padding:2px 8px;">',
            '<span class="fa fa-bar-chart"></span>  Detail',
            '</button>'].join('');
    }
    else
    {
       return ['<span class="label label-xs label-default" data-pjax="0" aria-label="Detail" title="Detail" style="padding:2px 8px">',
            '<span class="fa fa-bar-chart"></span>  Detail',
            '</span>'].join('');
    }
}

function operateFormatter(value, row, index) {
    return ['<a class="remove  btn btn-default btn-xs" data-pjax="0" data-method="post" data-confirm="Are you sure you want to delete this item?" aria-label="Delete" title="Delete" href="javascript:void(0)">',
        '<span class="fa fa-trash fa-lg"></span>&nbsp;Delete',
        '</a>'
    ].join('');
}

function typeFormatter(value,row,index){
    switch(value)
    {
        case 0: return 'single';
        case 1: return 'trio';
        case 2: return 'single-group';
        default : return '.';
    }
}

//annotation
function annoFormatter(value,row,index){
    if(value == 0)
        return ['<button class="anno btn btn-xs btn-default" data-pjax="0" aria-label="Anno" title="Annotation" style="width:75px;padding:2px 8px;">',
            '<span class="fa fa-building-o"></span> Annotate',
            '</button>'].join('');
    else if(value == 1)
        return ['<span class="label genes-label-anno label-warning" data-pjax="0" aria-label="Anno" title="Annotation" style="width:75px;">',
            '<span class="fa fa-spinner fa-pulse "></span> Annoing',
            '</span>'].join('');
    else if(value == -1)
        return ['<span class="label genes-label-anno label-danger" data-pjax="0" aria-label="Anno" title="Annotation" style="width:75px;">',
            '<span class="fa fa-times "></span> &nbsp Failure',
            '</span>'].join('');
    else
    {
        return ['<button class="detail btn btn-xs btn-success" data-pjax="0" aria-label="Detail" title="Detail" style="width:75px;padding:2px 8px;">',
            '<span class="fa fa-bar-chart"></span>  Analyse',
            '</button>'].join('');
       /* return ['<span class="label genes-label-anno label-success" data-pjax="0" aria-label="Anno" title="Annotation" style="width:75px;">',
            '<span class="fa fa-check "></span> Success',
            '</span>'].join('');*/
    }

}

window.annoEvents = {
    'click .anno': function (e,value,row,index) {
        var that = $(this);

        that.attr('disabled', 'disabled');
        that.removeClass('anno');

        window.gws.send_message({"A": "job", "T": "anno","analyse_id":row.id,"type":row.type},row.link_id,function(response,status){
            switch(status)
            {
                case -1:
                {
                    if ('desc' in response)
                        alert(response.message);
                    else
                        alert('annotation is fail!');
                    that.removeAttr('disabled');
                    that.addClass('anno');
                }break;
                case 1:
                {
                    var rows_data = $table.bootstrapTable('getData');
                    var index = rows_data.indexOf(row);
                    $table.bootstrapTable('updateCell', {
                        rowIndex: index,
                        fieldName: 'anno_status',
                        fieldValue: 1
                    });
                    that.removeAttr('disabled');
                    that.addClass('anno');
                }break;
                case 2:
                {
                    var rows_data = $table.bootstrapTable('getData');
                    var index = rows_data.indexOf(row);

                    if(response.R)
                        $table.bootstrapTable('updateCell', {
                            rowIndex: index,
                            fieldName: 'anno_status',
                            fieldValue: 2
                        });
                    else
                        $table.bootstrapTable('updateCell', {
                            rowIndex: index,
                            fieldName: 'anno_status',
                            fieldValue: -1
                        });
                }break;
            }

        });
    },
    'click .detail': function (e,value,row,index) {
        window.location = "./index.php?r=analyses/home&id=" + row.id;
    }
};