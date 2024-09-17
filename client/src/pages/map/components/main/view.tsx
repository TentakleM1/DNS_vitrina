import React, { useRef, useEffect } from "react";
import { CreateTusk } from "../create-tusk";
import { CreateStaff } from "../create-stuff";
import { useSelector } from "../../../../shared/store/store";

interface MainProps {
  isTask: boolean;
  isStuff: boolean;
}

type Block = (
  ctx: CanvasRenderingContext2D,
  x: number,
  y: number,
  width: number,
  height: number
) => void;

const block: Block = (ctx, x, y, width, height) => {
  ctx.fillStyle = "#B0E3E6";
  ctx.strokeStyle = "#0E8088";
  ctx.fillRect(x, y, width, height);
  ctx.strokeRect(x, y, width, height);
};

export const Main: React.FC<MainProps> = (props) => {
  const { isTask, isStuff } = props;
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const data = useSelector((state) => state);

  useEffect(() => {
    const canvas = canvasRef.current;
    if (canvas) {
      const ctx = canvas.getContext("2d");
      if (ctx) {
        block(ctx, 0, 20, 30, 300);

        block(ctx, 30, 355, 420, 30);

        block(ctx, 450, 355, 260, 30);

        block(ctx, 730, 355, 100, 30);

        block(ctx, 830, 365, 70, 20);

        block(ctx, 900, 355, 100, 30);

        block(ctx, 1000, 355, 120, 30);

        block(ctx, 1120, 335, 30, 50);

        block(ctx, 100, 1, 300, 30);

        block(ctx, 400, 1, 50, 20);

        block(ctx, 450, 1, 60, 50);

        block(ctx, 530, 50, 300, 30);

        block(ctx, 830, 1, 30, 50);

        block(ctx, 880, 1, 50, 50);

        block(ctx, 930, 50, 300, 30);

        block(ctx, 1230, 80, 30, 220);

        block(ctx, 1150, 335, 60, 50);

        block(ctx, 80, 100, 150, 30);

        block(ctx, 80, 180, 150, 30);

        block(ctx, 80, 270, 150, 30);

        block(ctx, 270, 100, 150, 30);

        block(ctx, 270, 180, 150, 30);

        block(ctx, 270, 270, 150, 30);

        block(ctx, 420, 100, 20, 30);

        block(ctx, 450, 100, 110, 80);

        block(ctx, 450, 220, 130, 30);

        block(ctx, 620, 220, 130, 30);

        block(ctx, 620, 120, 130, 70);

        block(ctx, 790, 150, 100, 30);

        block(ctx, 790, 220, 100, 30);

        block(ctx, 930, 130, 100, 50);

        block(ctx, 930, 220, 100, 30);

        block(ctx, 1080, 130, 100, 50);

        block(ctx, 1080, 220, 100, 30);

        ctx.fillStyle = "#FFE6CC";
        ctx.strokeStyle = "#D79B00";
        ctx.fillRect(550, 290, 40, 40);
        ctx.strokeRect(550, 290, 40, 40);

        ctx.fillStyle = "#FFE6CC";
        ctx.strokeStyle = "#D79B00";
        ctx.fillRect(700, 290, 40, 40);
        ctx.strokeRect(700, 290, 40, 40);

        ctx.fillStyle = "#FFE6CC";
        ctx.strokeStyle = "#D79B00";
        ctx.fillRect(845, 290, 40, 40);
        ctx.strokeRect(845, 290, 40, 40);

        ctx.fillStyle = "#FFE6CC";
        ctx.strokeStyle = "#D79B00";
        ctx.fillRect(980, 290, 40, 40);
        ctx.strokeRect(980, 290, 40, 40);
      }
    }
  }, [isTask, isStuff]);

  return (
    <main className="z-50 h-[40%] flex flex-row items-center justify-around w-full gap-2">
      {isTask ? (
        <CreateTusk />
      ) : isStuff ? (
        <CreateStaff />
      ) : (
        <>
          <div className="h-[400px] p-4 bg-[#EAE4DD] rounded-xl overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
            {data.stuff.stuff.map((card) => {
              // if (card.root) return;
              return (
                <section className="w-[300px] h-[100px] text-gray-800 flex-none flex flex-col gap-2 overflow-hidden cursor-pointer rounded-xl duration-500 hover:h-[250px] hover: hover:shadow-lg hover:bg-orange-500">
                  <div className="flex items-center">
                    <div className="w-20 h-20 m-2">
                      <img
                        src="https://i.pinimg.com/originals/0a/dd/87/0add874e1ea0676c4365b2dd7ddd32e3.jpg"
                        alt="usm"
                        className="rounded-full"
                      />
                    </div>
                    <div>
                      <span>{`${card.lastName} ${card.name}`}</span>
                    </div>
                  </div>
                  <div>
                    <ul>
                      <li>КБТ</li>
                      <li>Мониторы</li>
                      <li>Мобильные Аксы</li>
                    </ul>
                  </div>
                </section>
              );
            })}
          </div>
          <div className="w-[1000px] h-[400px] bg-[#EAE4DD] rounded-3xl overflow-y-hidden overflow-x-auto shadow-2xl">
            <canvas ref={canvasRef} width={1260} height={400}></canvas>
          </div>
        </>
      )}
      <div className="absolute left-[15%] top-0">
        <svg
          width="90px"
          height="90px"
          viewBox="0 0 400 400"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <g id="SVGRepo_bgCarrier" stroke-width="0" />

          <g
            id="SVGRepo_tracerCarrier"
            stroke-linecap="round"
            stroke-linejoin="round"
          />

          <g id="SVGRepo_iconCarrier">
            {" "}
            <path
              d="M245.2 134.289C294.12 73.9855 219.025 82.2174 208.126 76.763C204.296 74.849 200.528 56.3705 192.005 60.6375C178.88 67.2036 179.995 101.383 178.571 112.785C177.798 118.991 169.133 127.877 166.285 134.289C161.739 144.521 156.744 156.692 148.393 169.402C140.043 182.113 122.592 191.967 113.857 201.681C76.682 243.002 92.6204 291.579 133.435 322.992C174.716 354.764 347.131 342.906 298.399 269.769"
              stroke="#ff7235"
              stroke-opacity="0.9"
              stroke-width="16"
              stroke-linecap="round"
              stroke-linejoin="round"
            />{" "}
            <path
              d="M225.903 162.283C238.018 206.627 220.627 252.936 220.627 296.357C220.627 301.354 230.543 296.532 235.401 297.425"
              stroke="#ff7235"
              stroke-opacity="0.9"
              stroke-width="16"
              stroke-linecap="round"
              stroke-linejoin="round"
            />{" "}
            <path
              d="M162.667 208.879C172.419 210.315 181.319 217.474 188.222 224.166C222.582 257.481 178.688 279.87 176.257 291.647C175.708 294.311 187.035 296.145 189.31 296.389"
              stroke="#ff7235"
              stroke-opacity="0.9"
              stroke-width="16"
              stroke-linecap="round"
              stroke-linejoin="round"
            />{" "}
            <path
              d="M211.536 62.994C218.161 56.7795 219.425 67.6568 220.627 73.6378"
              stroke="#ff7235"
              stroke-opacity="0.9"
              stroke-width="16"
              stroke-linecap="round"
              stroke-linejoin="round"
            />{" "}
          </g>
        </svg>
      </div>
    </main>
  );
};
