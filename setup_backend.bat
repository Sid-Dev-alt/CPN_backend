git config user.email "sidk4@example.com"
git config user.name "Sid"
git init
git add .
git commit -m "Initialize standalone CPN_backend repository"
git remote add origin https://github.com/Sid-Dev-alt/CPN_backend.git || git remote set-url origin https://github.com/Sid-Dev-alt/CPN_backend.git
git branch -M main
git push -f origin main
