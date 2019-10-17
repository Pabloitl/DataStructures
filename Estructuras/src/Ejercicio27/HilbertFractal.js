function setup() {
    dim = 450;

    createCanvas(dim, dim);
    slider = createSlider(0, 10, 1, 1);
    noFill();
}

function draw() {
    background(255);
    datos();
    calculos();
}

function calculos() {
    x = 0;
    y = 0;

    beginShape();
    drawCurve(x, y, dim, 0, 0, dim, deepness);
    endShape();
}

function datos() { deepness = slider.value(); }

function drawCurve(x, y, xi, xj, yi, yj, n) {
    if (n <= 0)
       vertex(x += (xi + yi)/2, y += (xj + yj)/2);
    else {
       drawCurve(x,           y,           yi/2, yj/2,  xi/2,  xj/2, n-1);
       drawCurve(x+xi/2,      y+xj/2 ,     xi/2, xj/2,  yi/2,  yj/2, n-1);
       drawCurve(x+xi/2+yi/2, y+xj/2+yj/2, xi/2, xj/2,  yi/2,  yj/2, n-1);
       drawCurve(x+xi/2+yi,   y+xj/2+yj,  -yi/2,-yj/2, -xi/2, -xj/2, n-1);
    }
}
