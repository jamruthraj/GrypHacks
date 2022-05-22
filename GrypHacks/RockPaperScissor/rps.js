$("#rock").click(function () {
  play("rock");
});

$("#paper").click(function () {
  play("paper");
});

$("#scissors").click(function () {
  play("scissors");
});

function play(ch) {
  var cpu = Math.floor(Math.random() * 3) + 1;
  var p = 0;
  if (ch == "rock") {
    p = 1;
  }
  if (ch == "paper") {
    p = 2;
  }
  if (ch == "scissors") {
    p = 3;
  }
  display("p", p);
  display("q", cpu);
  $("#winner").css("font-size", "5.3rem");
  if (p == cpu) {
    $("#winner").text("Tie Game");
  } else {
    if ((p == 1 && cpu == 3) || (p == 2 && cpu == 1) || (p == 3 && cpu == 2)) {
      $("#winner").text("You Win");
    } else {
      $("#winner").text("CPU Wins");
    }
  }
  $("#strt").text("Click any button to go again");
}

function display(p, n) {
  if (p == "p") {
    if (n == 1) {
      $("#p").attr("src", "images/rock.png");
    }
    if (n == 2) {
      $("#p").attr("src", "images/paper.png");
    }
    if (n == 3) {
      $("#p").attr("src", "images/scissors.png");
    }
  } else {
    if (n == 1) {
      $("#cpu").attr("src", "images/rock.png");
    }
    if (n == 2) {
      $("#cpu").attr("src", "images/paper.png");
    }
    if (n == 3) {
      $("#cpu").attr("src", "images/scissors.png");
    }
  }
}
