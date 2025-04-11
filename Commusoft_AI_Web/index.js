const express = require("express");
const { exec } = require("child_process");
const app = express();
const port = process.env.PORT || 3000;

app.get("/runSmoke", (req, res) => {
  exec("sh ./runSmoke.sh", (error, stdout, stderr) => {
    if (error) {
      console.error(`❌ Error: ${error.message}`);
      return res.status(500).send("Error running script");
    }
    if (stderr) {
      console.error(`⚠️ Stderr: ${stderr}`);
    }
    console.log(`✅ Output: ${stdout}`);
    res.send("🚀 Smoke test triggered!");
  });
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
