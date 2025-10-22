const fs = require('node:fs');

// function getSum(o) {
//     let sum = 0;
//     console.log(`Enter for with obj: ${JSON.stringify(o)} and values: ${Object.values(o)}`)
//     for (val of Object.values(o)) {
//         console.log(val)
//         if (!Array.isArray(val)){
//             let n = parseInt(val)
//             if (Number.isInteger(val)) {
//                 sum+=n
//             } else if (typeof(val) == "string") {
//                 return 0
//             } else {
//                 sum += getSum(val)
//             }
//         } else {
//             sum+=getSum(val)
//         }
//     }
//     return sum;
// }

// function foo(val) {
//     if (Array.isArray(val)) {
//         return getSumArr(val)
//     } else if (typeof(val) == 'number') {
//         return  val
//     } else {
//         return getSumObj(val)
//     }
// }

function getSumArr(arr) {
    let sum = 0;
    for (val of arr) {
        if (Array.isArray(val)) {
            sum+=getSumArr(val)
        } else if (typeof(val) == 'number') {
            sum+=val
        } else {
            sum+=getSumObj(val)
        }
    }
    return sum;
}

function getSumObj(obj) {
    let sum = 0;
    for (val of Object.values(obj)) {
        if (Array.isArray(val)) {
            sum+=getSumArr(val)
        } else if (typeof(val) == 'number') {
            sum+=val
        } else {
            sum+=getSumObj(val)
        }
    }
    return sum;
}

fs.readFile('./input.txt', 'utf8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }

  let obj = JSON.parse(data);

  let ret = getSumObj(obj);
  
  console.log(ret)
});
