const fs = require('node:fs');

function exec(data) {
    let sum = 0
    data = data.replaceAll('  ', ' ').split('\n')
    
    let copies = []
    for (let i = 0; i < data.length; i++) {
      copies[i] = 1;
    }
    
    let scores = []
    for (let i = 0; i < data.length; i++){
        

        let line = data[i].split(': ')[1].split(' | ')
        winning = line[0].split(' ')
        numbers = line[1].split(' ')
        
        let cnt = 0
        for (num of numbers) {
          if (winning.includes(num)) {
            cnt++;
          }
        }
        scores[i] = cnt;
        for (let j = 1; j <= cnt; j++) {
          copies[i+j]+=copies[i];
        }
    }
    
    for (let k = 0; k < copies.length; k++) {
      sum+=copies[k]
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
