const express = require('express');
const { exec } = require('child_process');
const cors = require('cors');

const app = express();
const PORT = 3001;

app.use(cors());

app.get('/runSmoke', (req, res) => {
  exec('/Users/karnanathisivam/Desktop/Automation/OfficeWeb/Commusoft_Mobile/Commusoft_AI_Web/runSmoke.sh', (err, stdout, stderr) => {
    if (err) {
      console.error('❌ Error:', err.message);
      return res.status(500).send('Error running script');
    }
    console.log('✅ Output:', stdout);
    res.send('Smoke script started!');
  });
});

app.listen(PORT, () => {
  console.log(`🚀 Trigger server listening at http://localhost:${PORT}/runSmoke`);
});
