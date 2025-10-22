const fs = require('node:fs');

function exec(data) {
    let sum = 0
    data = data.replaceAll('  ', ' ').split('\n')
    for (l of data){
        let line = l.split(': ')[1].split(' | ')
        winning = line[0].split(' ')//.map(e => parseInt(e))
        numbers = line[1].split(' ')//.map(e => parseInt(e))
        
        let cnt = 0
        for (num of numbers) {
          if (winning.includes(num)) {
            if (cnt== 0) {cnt = 1}
            else {cnt *= 2}
          }
        }
        sum+=cnt
    }
    return sum
}

let input = ""

fs.readFile('./input.txt', 'utf8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(exec(data))
});
