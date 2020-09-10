const init = {
  monList: [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
    'July',
    'August',
    'September',
    'October',
    'November',
    'December',
  ],
  dayList: [
    'Sunday',
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday',
    'Saturday',
  ],
  today: new Date(),
  monForChange: new Date().getMonth(),
  activeDate: new Date(),
  getFirstDay: (yy, mm) => new Date(yy, mm, 1),
  getLastDay: (yy, mm) => new Date(yy, mm + 1, 0),
  nextMonth: function () {
    let d = new Date();
    d.setDate(1);
    d.setMonth(++this.monForChange);
    this.activeDate = d;
    return d;
  },
  prevMonth: function () {
    let d = new Date();
    d.setDate(1);
    d.setMonth(--this.monForChange);

    this.activeDate = d;
    return d;
  },
  addZero: (num) => (num < 10 ? '0' + num : num),
  activeDTag: null,
  getIndex: function (node) {
    let index = 0;
    while ((node = node.previousElementSibling)) {
      index++;
    }
    return index;
  },
};

const $calBody = document.querySelector('.cal-body');
const $btnNext = document.querySelector('.btn-cal.next');
const $btnPrev = document.querySelector('.btn-cal.prev');

/**
 * @param {number} date
 * @param {number} dayIn
 */
function loadDate(date, dayIn) {
  document.querySelector('.cal-date').textContent = date;
  document.querySelector('.cal-day').textContent = init.dayList[dayIn];
}

/**
 * @param {date} fullDate
 */
function loadYYMM(fullDate) {
  let yy = fullDate.getFullYear();
  let mm = fullDate.getMonth();
  let firstDay = init.getFirstDay(yy, mm);
  let lastDay = init.getLastDay(yy, mm);
  let markToday; // for marking today date

  if (mm === init.today.getMonth() && yy === init.today.getFullYear()) {
    markToday = init.today.getDate();
  }

  document.querySelector('.cal-month').textContent = init.monList[mm];
  document.querySelector('.cal-year').textContent = yy;

  let trtd = '';
  let startCount;
  let countDay = 0;
  for (let i = 0; i < 6; i++) {
    trtd += '<tr>';
    for (let j = 0; j < 7; j++) {
      if (i === 0 && !startCount && j === firstDay.getDay()) {
        startCount = 1;
      }
      if (!startCount) {
        trtd += '<td>';
      } else {
        let fullDate =
          yy + '.' + init.addZero(mm + 1) + '.' + init.addZero(countDay + 1);
        trtd += '<td class="day';
        trtd += markToday && markToday === countDay + 1 ? ' today" ' : '"';
        trtd += ` data-date="${countDay + 1}" data-fdate="${fullDate}">`;
      }
      trtd += startCount ? ++countDay : '';
      if (countDay === lastDay.getDate()) {
        startCount = 0;
      }
      trtd += '</td>';
    }
    trtd += '</tr>';
  }
  $calBody.innerHTML = trtd;
}

/**
 * @param {string} val
 */
function createNewList(val) {
  let id = new Date().getTime() + '';
  let yy = init.activeDate.getFullYear();
  let mm = init.activeDate.getMonth() + 1;
  let dd = init.activeDate.getDate();
  //const $target = $calBody.querySelector(`.day[data-date="${dd}"]`);

  let date = yy + '.' + init.addZero(mm) + '.' + init.addZero(dd);

  let eventData = {};
  eventData['date'] = date;
  eventData['complete'] = false;
  eventData['id'] = id;
  init.event.push(eventData);
  // $todoList.appendChild(createLi(id, val, date));
}

loadYYMM(init.today);
loadDate(init.today.getDate(), init.today.getDay());

// 다음버튼을 클릭하면, 다음달에 해당하는 캘린더를 로드
$btnNext.addEventListener('click', () => loadYYMM(init.nextMonth()));

// 이전버튼을 클릭하면, 이전달에 해당하는 캘린더를 로드
// 현재 월(month)의 캘린더에서는 이전캘린더를 열람하지 못하게해야한다.
$btnPrev.addEventListener('click', () => loadYYMM(init.prevMonth()));

// console.log('현재 시각 month: ' + init.today.getMonth()); // 9월(8)
// console.log('d의 month: ' + init.prevMonth().getMonth());

// let currentMonth = init.today.getMonth();
// let previousMonth = init.prevMonth().getMonth();
// document.querySelector('.prev').disabled = false;
// if (previousMonth == currentMonth - 1) {
//   document.querySelector('.prev').disabled = true;
// }

// if(<= init.today.getMonth()){

// }

// console.log(d);
// console.log(d.getMonth());
// console.log(init.today.getMonth());
// if (d.getMonth() == init.today.getMonth()) {
//   document.querySelector('.prev').disabled = true;
// } else {
//   document.querySelector('.prev').disabled = false;
// }

// 캘린더의 날짜 버튼을 클릭하면 일어나는 함수.
$calBody.addEventListener('click', (e) => {
  if (e.target.classList.contains('day')) {
 
    // console.log(this['dataset']['data-fdate']);

    if (init.activeDTag) {
      init.activeDTag.classList.remove('day-active');
    }
    let day = Number(e.target.textContent);
    loadDate(day, e.target.cellIndex);
    e.target.classList.add('day-active');
    init.activeDTag = e.target;
    init.activeDate.setDate(day);
  }
});
