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

        block(ctx, 30, 355, 1120, 30);

        block(ctx, 100, 1, 300, 30);

        block(ctx, 400, 1, 50, 20);

        block(ctx, 450, 1, 60, 50);

        block(ctx, 530, 50, 300, 30);

        block(ctx, 830, 1, 30, 50);

        block(ctx, 880, 1, 50, 50);

        block(ctx, 930, 50, 300, 30);

        block(ctx, 1230, 80, 30, 230);

        block(ctx, 1150, 335, 60, 50);
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
          <div className="h-[400px] p-2 overflow-x-hidden overflow-y-scroll flex-col flex gap-2">
            {data.stuff.stuff.map((card) => {
              if (card.root) return;
              return (
                <section className="w-[300px] h-[100px] flex-none flex flex-col items-center gap-2 overflow-hidden border border-orange-500 cursor-pointer rounded-xl duration-500 hover:h-[250px] hover: hover:shadow-lg hover:bg-orange-500 hover:text-amber-50">
                  <div className="flex justify-center items-center">
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
          <div className="w-[1000px] h-[400px] bg-[#393378] rounded-3xl overflow-y-hidden overflow-x-auto shadow-2xl">
            <canvas ref={canvasRef} width={1300} height={400}></canvas>
          </div>
        </>
      )}
    </main>
  );
};
