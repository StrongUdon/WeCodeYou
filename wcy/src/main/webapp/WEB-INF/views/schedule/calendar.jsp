<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="ko">
<head>

<link href="<c:url value='/resources/vendor/calcss/fullcalendar.min.css' />" rel='stylesheet' />
<link href="<c:url value='/resources/vendor/calcss/bootstrap.min.css' />" rel='stylesheet' />
<link href="<c:url value='/resources/vendor/calcss/select2.min.css' />" rel='stylesheet' />
<link href="<c:url value='/resources/vendor/calcss/calendar.css' />" rel='stylesheet' />


<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />

<meta charset="UTF-8">

<title>스케줄</title>

</head>

<script type="text/javascript">

document.addEventListener('DOMContentLoaded', function() {
	var Calendar = FullCalendar.Calendar;

var calendar = new Calendar($('#calendar'),{

		  
	  header: {
	    left: 'today, prevYear, nextYear, viewWeekends',
	    center: 'prev, title, next',
	    right: 'month,listWeek'
	  },
	  views: {
	    month: {
	      columnFormat: 'dddd'
	    },
	    agendaWeek: {
	      columnFormat: 'M/D ddd',
	      titleFormat: 'YYYY년 M월 D일',
	      eventLimit: false
	    },
	    agendaDay: {
	      columnFormat: 'dddd',
	      eventLimit: false
	    },
	    listWeek: {
	      columnFormat: ''
	    }
	  },
		
	  events: [ /* db에서 이벤트 받아옴 */
          
	     	<c:forEach var="el" items="${el}">
		
				{
				   id : '${el.schedule_no}'
    			 , title : '${el.schedule_title}' // off_no ?
     	 		 , start : '${el.schedule_start_date}'
   				 , end : '${el.schedule_end_date}'
   				 , backgroundColor : '${el.schedule_bg_color}'
   				 , description : '${el.schedule_detail}' 				 
   				 , allday : true
 	 			},
				</c:forEach>
 	 	
			],


	  eventResize: true,
	  select: false,
	  eventClick: false, 
	  locale: 'ko',
	  timezone: "local",
	  nextDayThreshold: "09:00:00",
	  allDaySlot: true,
	  displayEventTime: false,
	  displayEventEnd: true,
	  firstDay: 0, //월요일이 먼저 오게 하려면 1
	  weekNumbers: false,
	  selectable: true,
	  weekNumberCalculation: "ISO",
	  eventLimit: true,
	  views: {
	    month: {
	      eventLimit: 12
	    }
	  },
	  eventLimitClick: 'week', //popover
	  navLinks: true,

	  timeFormat: 'HH:mm',
	  
	  defaultTimedEventDuration: '01:00:00',
	  editable: false,
	  minTime: '01:00:00',
	  maxTime: '24:00:00',
	  slotLabelFormat: 'HH:mm',
	  weekends: true,
	  nowIndicator: true,
	  dayPopoverFormat: 'MM/DD dddd',
	  longPressDelay: 0,
	  eventLongPressDelay: 0,
	  selectLongPressDelay: 0
	  

	});

	calendar.render();
});
</script>



<body>

	<div class="container">

		<div id="wrapper">
			<div id="loading"></div>
			<div id="calendar"></div>
		</div>

	</div>
	<!-- /.container -->

<script src = "<c:url value='/resources/vendor/caljs/jquery.min.js' />"></script>
<script src = "<c:url value='/resources/vendor/caljs/bootstrap.min.js' />"></script>
<script src = "<c:url value='/resources/vendor/caljs/moment.min.js' />"></script>
<script src = "<c:url value='/resources/vendor/caljs/fullcalendar.min.js' />"></script>
<script src = "<c:url value='/resources/vendor/caljs/select2.min.js' />"></script>
<script src = "<c:url value='/resources/vendor/caljs/ko.js' />"></script>


</body>
</html>